package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Drzava;

@Repository
public interface DrzavaRepository extends JpaRepository<Drzava, String> {
	
	public Drzava findByDrzavaId(int drzavaId);
	
}
