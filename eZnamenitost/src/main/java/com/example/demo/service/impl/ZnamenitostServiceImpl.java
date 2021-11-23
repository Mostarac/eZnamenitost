package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ZnamenitostSearchRequest;
import com.example.demo.DTO.ZnamenitostUpsertDTO;
import com.example.demo.model.OcjenaZnamenitost;
import com.example.demo.model.Opcina;
import com.example.demo.model.Znamenitost;
import com.example.demo.model.ZnamenitostVaznost;
import com.example.demo.repository.OcjenaZnamenitostRepository;
import com.example.demo.repository.OpcinaRepository;
import com.example.demo.repository.ZnamenitostRepository;
import com.example.demo.service.ZnamenitostService;

@Service
public class ZnamenitostServiceImpl implements ZnamenitostService {
	
	@Autowired
    private ZnamenitostRepository znamenitostRepository;
	
	@Autowired
	private OpcinaRepository opcinaRepository;
	
	@Autowired
	private OcjenaZnamenitostRepository ocjenaRepository;
	
	@PersistenceContext
	EntityManager em;

	public Znamenitost dodajZnamenitost(ZnamenitostUpsertDTO znamenitost) {
		
		Opcina opc = opcinaRepository.findById(znamenitost.opcinaId).get();
		
		Znamenitost nova = new Znamenitost(znamenitost.naziv, znamenitost.opis, znamenitost.aktivno, znamenitost.latitude, znamenitost.longitude, znamenitost.vaznost, opc);
		
		znamenitostRepository.saveAndFlush(nova);
		
		return nova;
		
	}

	public Znamenitost updateZnamenitost(Long znamenitostId, ZnamenitostUpsertDTO znamenitost) {
		
		Znamenitost zn = znamenitostRepository.findById(znamenitostId).get();
		
		zn.setAktivno(znamenitost.aktivno);
		zn.setLongitude(znamenitost.longitude);
		zn.setLatitude(znamenitost.latitude);
		zn.setNaziv(znamenitost.naziv);
		zn.setOpis(znamenitost.opis);
		zn.setVaznost(znamenitost.vaznost);
		if(zn.getOpcina().getOpcinaId()!=znamenitost.opcinaId) {
			Opcina opc = opcinaRepository.findById(znamenitost.opcinaId).get();
			zn.setOpcina(opc);
		}
		
		znamenitostRepository.saveAndFlush(zn);
		
		return zn;
	}

	public Znamenitost izmjeniStatus(boolean aktivno, Long znamenitostId) {
		
		Znamenitost zn = znamenitostRepository.findById(znamenitostId).get();
		zn.setAktivno(aktivno);
		znamenitostRepository.saveAndFlush(zn);
		
		return zn;
		
	}

	public List<Znamenitost> getZnamenitosti(ZnamenitostSearchRequest znamenitost) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Znamenitost> cq = cb.createQuery(Znamenitost.class);

	    Root<Znamenitost> znm = cq.from(Znamenitost.class);
	    List<Predicate> predicates = new ArrayList<>();
	    
	    if (znamenitost.naziv != null) {
	        predicates.add(cb.like(znm.get("naziv"), "%" + znamenitost.naziv + "%"));
	    }
	    if (znamenitost.vaznost != null) {
	        predicates.add(cb.equal(znm.get("vaznost"), znamenitost.vaznost));
	    }
	    
	    //Samo aktivne znamenitosti
	    predicates.add(cb.equal(znm.get("aktivno"), true));
	    
	    cq.where(predicates.toArray(new Predicate[0]));

	    return em.createQuery(cq).getResultList();
	    
	}

	public OcjenaZnamenitost ocjeniZnamenitost(Long znamenitostId, Long ocjena) {
		
		Znamenitost zn = znamenitostRepository.findById(znamenitostId).get();
		
		OcjenaZnamenitost oz = new OcjenaZnamenitost(ocjena, zn);
		
		ocjenaRepository.saveAndFlush(oz);
		
		return oz;
	}
	
}
