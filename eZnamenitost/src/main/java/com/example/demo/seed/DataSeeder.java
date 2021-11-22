package com.example.demo.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Drzava;
import com.example.demo.model.Opcina;
import com.example.demo.repository.DrzavaRepository;
import com.example.demo.repository.OpcinaRepository;

@Component
public class DataSeeder implements CommandLineRunner {

	@Autowired
	DrzavaRepository drzavaRepository;
	
	@Autowired
	OpcinaRepository opcinaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Seed();
	}

	private void Seed() {
		if (drzavaRepository.count() == 0) {
			Drzava drzava1 = new Drzava("Bosna i Hercegovina");
			Drzava drzava2 = new Drzava("Srbija");
			
			drzavaRepository.save(drzava1);
			drzavaRepository.save(drzava2);
			
			Opcina opcina1 = new Opcina("Gradacac", drzava1);
			Opcina opcina2 = new Opcina("Tuzla", drzava1);
			Opcina opcina3 = new Opcina("Sarajevo", drzava1);
			
			Opcina opcina4 = new Opcina("Beograd", drzava2);
			Opcina opcina5 = new Opcina("Novi Sad", drzava2);
			Opcina opcina6 = new Opcina("Novi Pazar", drzava2);
			
			opcinaRepository.save(opcina1);
			opcinaRepository.save(opcina2);
			opcinaRepository.save(opcina3);
			opcinaRepository.save(opcina4);
			opcinaRepository.save(opcina5);
			opcinaRepository.save(opcina6);
			
		}
		//System.out.println(userRepository.count());
	}
	
}
