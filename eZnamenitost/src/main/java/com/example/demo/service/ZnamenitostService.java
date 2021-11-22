package com.example.demo.service;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.ZnamenitostUpsertDTO;
import com.example.demo.model.Znamenitost;

@Component
public interface ZnamenitostService {

	
	public Znamenitost dodajZnamenitost(ZnamenitostUpsertDTO znamenitost);
	
	public Znamenitost updateZnamenitost(Long znamenitostId, ZnamenitostUpsertDTO znamenitost);
	
	public Znamenitost izmjeniStatus(boolean aktivno, Long znamenitostId);
	
}
