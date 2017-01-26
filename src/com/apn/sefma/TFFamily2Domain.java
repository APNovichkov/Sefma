package com.apn.sefma;

public class TFFamily2Domain {

	int familyId;
	int domainId;
	
	public TFFamily2Domain(int familyId, int domainId){
		this.familyId = familyId;
		this.domainId = domainId;
	}
	
	public void setFamilyId(int familyId){
		this.familyId = familyId;
	}
	
	public void setDomainId(int domainId){
		this.domainId = domainId;
	}
	
	public int getFamilyId(){
		return familyId;
	}
	
	public int getDomainId(){
		return domainId;
	}
}
