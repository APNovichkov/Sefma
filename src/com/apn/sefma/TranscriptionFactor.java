package com.apn.sefma;

public class TranscriptionFactor {

	int transcriptionFactorId;
	int taxonomyId;
	int locusId;
	String name;
	int familyId;
	
	public TranscriptionFactor(int transcriptionFactorId, int taxonomyId, int locusId, String name, int familyId){
		this.transcriptionFactorId = transcriptionFactorId;
		this.taxonomyId = taxonomyId;
		this.locusId = locusId;
		this.name = name;
		this.familyId = familyId;
	}
	
	
	public void setTranscriptionFactorId(int transcriptionFactorId){
		this.transcriptionFactorId = transcriptionFactorId;
	}
	
	public void setTaxonomyId(int taxonomyId){
		this.taxonomyId = taxonomyId;
	}
	
	public void setLocusId(int locusId){
		this.locusId = locusId;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setFamilyId(int familyId){
		this.familyId = familyId;
	}
	
	public int getTranscriptionFactorId(){
		return transcriptionFactorId;
	}
	
	public int getTaxonomyId(){
		return taxonomyId;
	}
	
	public int getLocusId(){
		return locusId;
	}
	
	public String getName(){
		return name;
	}
	
	public int getFamilyId(){
		return familyId;
	}
	
}
