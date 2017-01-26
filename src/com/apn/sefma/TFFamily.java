package com.apn.sefma;

import java.lang.annotation.Inherited;

import javax.jws.soap.InitParam;



public class TFFamily {

	
	int familyId;
	String familyName;
	int signatureCount;
	int pogCount;
	int motifCount;
	int tfsCount;
	int genomeCount;
	String description;
	
	public TFFamily(int familyId, String familyName, int signatureCount, int pogCount, int motifCount, int tfsCount, int genomeCount, String description){
		this.familyId = familyId;
		this.familyName = familyName;
		this.signatureCount = signatureCount;
		this.pogCount = pogCount;
		this.motifCount = motifCount;
		this.tfsCount = tfsCount;
		this.genomeCount = genomeCount;
		this.description = description;
	}
	
	public TFFamily(){
		
	}
	
	public void setFamilyId(int familyId){
		this.familyId = familyId;
	}
	
	public void setFamilyName(String familyName){
		this.familyName = familyName;
	}
	
	public void setSignatureCount(int signatureCount){
		this.signatureCount = signatureCount;
	}
	
	public void setPogCount(int pogCount){
		this.pogCount = pogCount;
	}
	
	public void setMotifCount(int motifCount){
		this.motifCount = motifCount;
	}
	
	public void setTfsCount(int tfsCount){
		this.tfsCount = tfsCount;
	}
	
	public void setGenomeCount(int genomeCount){
		this.genomeCount = genomeCount;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	
	public int getFamilyId(){
		return familyId; 
	}
	
	
	public String getFamilyName(){
		return familyName;
	}
	
	public int getSigantureCount(){
		return signatureCount; 
	}
	
	public int getPogCount(){
		return pogCount; 
	}
	
	public int getMotifCount(){
		return motifCount; 
	}
	
	public int getTfsCount(){
		return tfsCount; 
	}
	
	public int getGenomeCount(){
		return genomeCount; 
	}
	
	public String getDescription(){
		return description; 
	}
}

