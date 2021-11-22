package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Drzava;
import com.example.demo.service.DrzavaService;

@RestController
@RequestMapping(value="/drzava")
public class DrzavaController {

	@Autowired
	DrzavaService drzavaService;
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Drzava> getDrzave() {
         return drzavaService.getAllDrzave();
    }
	
}
