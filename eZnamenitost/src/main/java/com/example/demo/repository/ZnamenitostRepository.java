package com.example.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Znamenitost;

@Repository
public interface ZnamenitostRepository extends JpaRepository<Znamenitost, Long> {

	
}
