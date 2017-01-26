package com.apn.sefma;

public class Genome {

	int taxonomyId;
	String name;
	
	
	public Genome(int taxonomyId, String name){
		this.taxonomyId = taxonomyId;
		this.name = name;
	}
	
	public void setTaxonomyId(int taxonomyId){
		this.taxonomyId = taxonomyId;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getTaxonomyId(){
		return taxonomyId;
	}
	
	public String getName(){
		return name;
	}
}
