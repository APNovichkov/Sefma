package com.apn.sefma;

public class Tfs2Pog {

	int pogId;
	int tfsId;
	
	public Tfs2Pog(int pogId, int tfsId){
		this.pogId = pogId;
		this.tfsId = tfsId;
	}
	
	public void setPogId(int pogId){
		this.pogId = pogId;
	}
	
	public void setTfsId(int tfsId){
		this.tfsId = tfsId;
	}
	
	public int getPogId(){
		return pogId;
	}
	
	public int getTfsId(){
		return tfsId;
	}
	
}
