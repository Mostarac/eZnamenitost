package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="znamenitost")
public class Znamenitost {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long znamenitostId;
	
	@Column(name = "naziv")
	private String naziv;
	
	@Column(name = "opis", length=4096)
	private String opis;
	
	@Column(name = "aktivno")
	private boolean aktivno;
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "longitude")
	private double longitude;
	
	@Column(name = "vaznost")
    @Enumerated(EnumType.STRING)
	private ZnamenitostVaznost vaznost;
	
    @OneToMany(mappedBy = "znamenitost", fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("znamenitost")
    private List<ZnamenitostSlika> slike = new ArrayList<>();
    
    @OneToMany(mappedBy = "znamenitost", fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    //@JsonIgnoreProperties("znamenitost")
    @JsonIgnore
    private List<OcjenaZnamenitost> ocjene = new ArrayList<>();
    
    @Formula("(SELECT AVG(ocz.ocjena) FROM ocjena_znamenitost AS ocz WHERE ocz.znamenitost_id=znamenitost_id)")
    private Double ProsjecnaOcjena;
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "opcina_id", referencedColumnName = "opcinaId")
    @JsonIgnoreProperties("znamenitosti")
    private Opcina opcina;

    
    public Znamenitost() {
		
	}
	
	public Znamenitost (String naziv, String opis, boolean aktivno, double latitude, double longitude, ZnamenitostVaznost vaznost, Opcina opcina) {
		this.naziv = naziv;
		this.opis = opis;
		this.aktivno = aktivno;
		this.latitude = latitude;
		this.longitude = longitude;
		this.vaznost = vaznost;
		this.opcina = opcina;
	}
	
	
	public void setZnamenitostId (Long znamenitostId) {
    	this.znamenitostId = znamenitostId;
    }
	
	public Long getZnamenitostId () {
    	return znamenitostId;
    }
	
	public void setNaziv (String naziv) {
    	this.naziv = naziv;
    }
	
	public String getNaziv () {
		
    	return naziv;
    }
	
	public void setOpis (String opis) {
    	this.opis = opis;
    }
	
	public String getOpis () {
		
    	return opis;
    }
	
	public boolean getAktivno () {
		return aktivno;
	}
	
	public void setAktivno (boolean aktivno) {
		this.aktivno = aktivno;
	}
	
	public void setLatitude (double latitude) {
    	this.latitude = latitude;
    }
	
	public double getLatitude () {
    	return latitude;
    }
	
	public void setLongitude (double longitude) {
    	this.longitude = longitude;
    }
	
	public double getLongitude () {
    	return longitude;
    }
	
	public List<ZnamenitostSlika> getZnamenitostSlike() {
		return slike;
	}
	
	public void setSlike (List<ZnamenitostSlika> slike) {
		this.slike = slike;
	}
	
	public void setVaznost(ZnamenitostVaznost vaznost) {
		this.vaznost = vaznost;
	}
	
	public ZnamenitostVaznost getVaznost() {
		return vaznost;
	}
	
	public Opcina getOpcina() {
		return this.opcina;
	}
	
	public void setOpcina(Opcina opcina) {
		this.opcina = opcina;
	}
	
	public Double getProsjecnaOcjena() {
		return ProsjecnaOcjena;
	}
	
	public void setProsjecnaOcjena(Double ProsjecnaOcjena) {
		this.ProsjecnaOcjena = ProsjecnaOcjena;
	}
	
}
