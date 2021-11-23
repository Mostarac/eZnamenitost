package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ZnamenitostSearchRequest;
import com.example.demo.DTO.ZnamenitostUpsertDTO;
import com.example.demo.model.OcjenaZnamenitost;
import com.example.demo.model.Znamenitost;
import com.example.demo.service.ZnamenitostService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/znamenitost")
public class ZnamenitostController {

	@Autowired
	ZnamenitostService znamenitostService;
	
	@PostMapping("/dodaj")
	public Znamenitost createZnamenitost(@RequestBody ZnamenitostUpsertDTO znamenitost) {
	    return znamenitostService.dodajZnamenitost(znamenitost);
	}
	
	@PutMapping("/update/{id}")
	public Znamenitost updateZnamenitost(@PathVariable("id") long id, @RequestBody ZnamenitostUpsertDTO znamenitost) {
		return znamenitostService.updateZnamenitost(id, znamenitost);
	}
	
	@PutMapping("/izmjenistatus/{id}")
	public Znamenitost izmjeniStatus(@PathVariable("id") long id, @RequestParam("status") Boolean status) {
		return znamenitostService.izmjeniStatus(status, id);
	}
	
	@GetMapping("/get")
	public List<Znamenitost> getZnamenitosti(@RequestBody ZnamenitostSearchRequest znamenitost) {
		return znamenitostService.getZnamenitosti(znamenitost);
	}
	
	@PostMapping("/ocjeni")
	public OcjenaZnamenitost ocjeniZnamenitost(@RequestParam("id") long id, @RequestParam("ocjena") long ocjena) {
		return znamenitostService.ocjeniZnamenitost(id, ocjena);
	}
	
}
