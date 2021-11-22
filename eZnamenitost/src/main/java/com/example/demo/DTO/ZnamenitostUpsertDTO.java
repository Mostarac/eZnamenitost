package com.example.demo.DTO;


import com.example.demo.model.ZnamenitostVaznost;


public class ZnamenitostUpsertDTO {
	
	public String naziv;
	
	public String opis;
	
	public boolean aktivno;
	
	public double latitude;
	
	public double longitude;
	
	public ZnamenitostVaznost vaznost;
	
	public Long opcinaId;

    
    public ZnamenitostUpsertDTO() {
		
	}

}
