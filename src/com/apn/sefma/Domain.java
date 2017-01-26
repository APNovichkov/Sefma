package com.apn.sefma;

public class Domain {
	
	int domainId;
	String domainName;
	
	public Domain(int domainId, String domainName){
		this.domainId = domainId;
		this.domainName = domainName;
	}
	
	
	
	public void setDomainId(int domainId){
		this.domainId = domainId;
	}
	
	public void setDomainName(String domainName){
		this.domainName = domainName;
	}
	
	public int getDomainId(){
		return domainId; 
	}
	
	public String getDomainName(){
		return domainName;
	}
}
