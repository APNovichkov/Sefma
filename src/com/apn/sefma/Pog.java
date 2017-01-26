package com.apn.sefma;

public class Pog {

	int pogId;
	String pogName;
	String pogPath;
	
	public Pog(int pogId, String pogName, String pogPath){
		this.pogId = pogId;
		this.pogName = pogName;
		this.pogPath = pogPath;
	}
	
	public void setPogId(int pogId){
		this.pogId = pogId;
	}
	
	public void setPogName(String pogName){
		this.pogName = pogName;
	}
	
	public void setPogPath(String pogPath){
		this.pogPath = pogPath;
	}
	
	public int getPogId(){
		return pogId;
	}
	
	public String getPogName(){
		return pogName;
	}
	
	public String getPogPath(){
		return pogPath;
	}
	
	
}
