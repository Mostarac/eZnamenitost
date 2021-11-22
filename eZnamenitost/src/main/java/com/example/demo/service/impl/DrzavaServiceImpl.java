package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Drzava;
import com.example.demo.repository.DrzavaRepository;
import com.example.demo.service.DrzavaService;

@Service
public class DrzavaServiceImpl implements DrzavaService {

	@Autowired
    private DrzavaRepository drzavaRepository;

	public Drzava findByDrzavaId(String drzavaId) {
		return drzavaRepository.getById(drzavaId);
	}

	public List<Drzava> getAllDrzave() {
		return drzavaRepository.findAll();
	}
}
