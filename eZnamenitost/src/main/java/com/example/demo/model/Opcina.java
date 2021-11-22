package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="opcina")
public class Opcina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int opcinaId;
	
	@Column(name = "naziv")
	private String naziv;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "drzava_id", referencedColumnName = "drzavaId")
    @JsonIgnoreProperties("opcine")
    private Drzava drzava;
	
	public Opcina() {
		
	}
	
	public Opcina (String naziv, Drzava drzava) {
		this.naziv = naziv;
		this.drzava = drzava;
	}
	
	public int getOpcinaId() {
		return opcinaId;
	}
	
	public void setOpcinaId(int opcinaId) {
		this.opcinaId = opcinaId;
	}
	
	public String getNazivOpcine() {
		return naziv;
	}
	
	public void setNazivOpcine(String naziv) {
		this.naziv = naziv;
	}
	
}
