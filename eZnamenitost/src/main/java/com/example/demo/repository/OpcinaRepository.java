package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Opcina;

@Repository
public interface OpcinaRepository extends JpaRepository<Opcina, String> {
	
	

}
