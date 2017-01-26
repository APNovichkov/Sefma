package com.apn.sefma;

public class Site {

	int siteId;
	int motifId;
	int transcriptionFactorId;
	String sequence;
	int locusId;
	String geneName;
	String genomeName;
	String taxon;
	String locusTag;
	
	
	public Site(int siteId, int locusId, String sequence, int motifId) {
		this.siteId = siteId;
		this.locusId = locusId;
		this.sequence = sequence;
		this.motifId = motifId;
	}

	public void setSiteId(int siteId){
		this.siteId = siteId;
	}
	
	public void setMotifId(int motifId){
		this.motifId = motifId;
	}
	
	public void setTranscriptionFactorId(int transcriptionFactorId){
		this.transcriptionFactorId = transcriptionFactorId;
	}
	
	public void setSequence(String sequence){
		this.sequence = sequence;
	}
	
	public void setLocusId(int locusId){
		this.locusId = locusId;
	}
	
	public void setGeneName(String geneName){
		this.geneName = geneName;
	}
	
	public void setGenomeName(String genomeName){
		this.genomeName = genomeName;
	}
	
	public void setTaxon(String taxon){
		this.taxon = taxon;
	}
	
	public void setLocusTag(String locusTag){
		this.locusTag = locusTag;
	}
	
	public int getSiteId(){
		return siteId;
	}
	
	public int getMotifId(){
		return motifId;
	}
	
	public int getTranscriptionFactorId(){
		return transcriptionFactorId;
	}
	
	public String getSequence(){
		return sequence;
	}
	
	public int getLocusId(){
		return locusId;
	}
	
	public String getGeneName(){
		return geneName;
	}
	
	public String getGenomeName(){
		return genomeName;
	}
	
	public String getTaxon(){
		return taxon;
	}
	
	public String getLocusTag(){
		return locusTag;
	}
	
	
}
