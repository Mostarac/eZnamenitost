package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ocjena_znamenitost")
public class OcjenaZnamenitost {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ocjenaZnamenitostId;
	
	@Column(name = "ocjena")
	private Long ocjena;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "znamenitost_id", referencedColumnName = "znamenitostId")
    @JsonIgnoreProperties("ocjene")
    private Znamenitost znamenitost;
	
	public Long getOcjena() {
		return ocjena;
	}
	
	public void setOcjena(Long ocjena) {
		this.ocjena = ocjena;
	}
	
	public void setZnamenitost(Znamenitost znamenitost) {
		this.znamenitost = znamenitost;
	}
	
	public Znamenitost getZnamenitost() {
		return znamenitost;
	}
	
	public OcjenaZnamenitost() {
		
	}
	
	public OcjenaZnamenitost(Long ocjena, Znamenitost znamenitost) {
		this.ocjena = ocjena;
		this.znamenitost = znamenitost;
	}
	
}
