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
@Table(name ="znamenitost_slika")
public class ZnamenitostSlika {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long znamenitostSlikaId;
	
	@Column(name = "putanja")
	private String putanja;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "znamenitost_id", referencedColumnName = "znamenitostId")
    @JsonIgnoreProperties("slike")
    private Znamenitost znamenitost;
	
	public String getPutanja() {
		return putanja;
	}
	
	public void setPutanja(String putanja) {
		this.putanja = putanja;
	}
	
}
