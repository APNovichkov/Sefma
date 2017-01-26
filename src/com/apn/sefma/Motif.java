package com.apn.sefma;

public class Motif {

	int motifId;
	int pogId;
	int memeIndex;
	double eValue;
	int siteCount;
	
	
	public Motif(int motifId, int pogId, int memeIndex, double eValue, int siteCount){
		this.motifId = motifId;
		this.pogId = pogId;
		this.memeIndex = memeIndex;
		this.eValue = eValue;
		this.siteCount = siteCount;
	}
	
	public Motif(int motifId, int pogId, int memeIndex) {
		this.motifId = motifId;
		this.pogId = pogId;
		this.memeIndex = memeIndex;
	}

	public void setMotifId(int motifId){
		this.motifId = motifId;
	}
	
	public void setPogId(int pogId){
		this.pogId = pogId;
	}	
	
	public void setMemeIndex(int memeIndex){
		this.memeIndex = memeIndex;
	}
	
	public void setEValue(double eValue){
		this.eValue = eValue;
	}
	
	public void setSiteCount(int siteCount){
		this.siteCount = siteCount;
	}
	
	public int getMotifId(){
		return motifId;
	}
	
	public int getPogId(){
		return pogId;
	}
	
	public int getMemeIndex(){
		return memeIndex;
	}
	
	public double getEValue(){
		return eValue;
	}
	
	public int getSiteCount(){
		return siteCount;
	}
	
	
	
}
