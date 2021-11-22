package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ZnamenitostUpsertDTO;
import com.example.demo.model.Opcina;
import com.example.demo.model.Znamenitost;
import com.example.demo.model.ZnamenitostVaznost;
import com.example.demo.repository.OpcinaRepository;
import com.example.demo.repository.ZnamenitostRepository;
import com.example.demo.service.ZnamenitostService;

@Service
public class ZnamenitostServiceImpl implements ZnamenitostService {
	
	@Autowired
    private ZnamenitostRepository znamenitostRepository;
	
	@Autowired
	private OpcinaRepository opcinaRepository;

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
	
}
