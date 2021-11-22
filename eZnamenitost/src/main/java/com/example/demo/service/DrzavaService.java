package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Drzava;

@Component
public interface DrzavaService {
	
	public List<Drzava> getAllDrzave();
	
	public Drzava findByDrzavaId(String drzavaId);
}
