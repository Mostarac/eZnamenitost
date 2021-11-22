package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="drzava")
public class Drzava  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long drzavaId;
	
	@Column(name = "naziv")
	private String naziv;
	
    @OneToMany(mappedBy = "drzava", fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("drzava")
    private List<Opcina> opcine = new ArrayList<>();

    
    public Drzava() {
		
	}
	
	public Drzava (String naziv) {
		this.naziv = naziv;
	}
	
	
	public void setDrzavaId (Long drzavaId) {
    	this.drzavaId = drzavaId;
    }
	
	public Long getDrzavaId () {
    	return drzavaId;
    }
	
	public void setNaziv (String naziv) {
    	this.naziv = naziv;
    }
	
	public String getNaziv () {
		
    	return naziv;
    }
	
	public List<Opcina> getOpcine() {
		return opcine;
	}
	
	public void setOpcine (List<Opcina> opcine) {
		this.opcine = opcine;
	}

	
}
