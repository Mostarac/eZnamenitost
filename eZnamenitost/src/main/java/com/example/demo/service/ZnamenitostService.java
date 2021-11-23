package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.ZnamenitostSearchRequest;
import com.example.demo.DTO.ZnamenitostUpsertDTO;
import com.example.demo.model.OcjenaZnamenitost;
import com.example.demo.model.Znamenitost;

@Component
public interface ZnamenitostService {

	
	public Znamenitost dodajZnamenitost(ZnamenitostUpsertDTO znamenitost);
	
	public Znamenitost updateZnamenitost(Long znamenitostId, ZnamenitostUpsertDTO znamenitost);
	
	public Znamenitost izmjeniStatus(boolean aktivno, Long znamenitostId);
	
	public List<Znamenitost> getZnamenitosti(ZnamenitostSearchRequest znamenitost);

	public OcjenaZnamenitost ocjeniZnamenitost(Long znamenitostId, Long ocjena);
	
}
