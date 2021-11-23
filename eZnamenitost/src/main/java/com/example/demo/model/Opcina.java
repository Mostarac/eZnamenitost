package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="opcina")
public class Opcina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long opcinaId;
	
	@Column(name = "naziv")
	private String naziv;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "drzava_id", referencedColumnName = "drzavaId")
    @JsonIgnoreProperties("opcine")
    private Drzava drzava;
	
	@OneToMany(mappedBy = "opcina", fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    //@JsonIgnoreProperties("opcina")
	@JsonIgnore
    private List<Znamenitost> znamenitosti = new ArrayList<>();
	
	public Opcina() {
		
	}
	
	public Opcina (String naziv, Drzava drzava) {
		this.naziv = naziv;
		this.drzava = drzava;
	}
	
	public Long getOpcinaId() {
		return opcinaId;
	}
	
	public void setOpcinaId(Long opcinaId) {
		this.opcinaId = opcinaId;
	}
	
	public String getNazivOpcine() {
		return naziv;
	}
	
	public void setNazivOpcine(String naziv) {
		this.naziv = naziv;
	}
	
	public List<Znamenitost> getZnamenitosti() {
		return znamenitosti;
	}
	
	public void setZnamenitosti (List<Znamenitost> znamenitosti) {
		this.znamenitosti = znamenitosti;
	}
	
}
