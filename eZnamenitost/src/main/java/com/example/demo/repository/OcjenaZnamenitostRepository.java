package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.OcjenaZnamenitost;

@Repository
public interface OcjenaZnamenitostRepository extends JpaRepository<OcjenaZnamenitost, Long> {
	
}
