package com.apn.sefma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class createSites {
	
	static final int MAX_POG_COUNT = 1000;
	static final int MAX_MOTIF_COUNT = 20;
	static final int MAX_BYTE_COUNT = 8;
	
	public static final int BYTE_SIZE = 8;
	
	private static final int LETTER_INDEX_MAX = 256;
	
	static Vector<String> families;
	static String familyNamesLocation = "/Users/andrey/Documents/Sefma/familyName.txt";
	
	
	static StringBuffer sites = new StringBuffer("");
	
	

	public static void main(String[] args) {
		

	}
	
	public static void fillFamilies(BufferedReader br) throws IOException{
		families = new Vector<String>();
		try {
			for(String line = br.readLine(); line != null; line = br.readLine()){
				line.trim();
				if(line.length() == 0) continue;
				
				String[] tokens = line.split(",");
				String familyName = tokens[1].trim();
		
				families.add(familyName);
			}
		} finally {
			br.close();
		}
	}
	
	public static void runThroughClusters() throws IOException{
		String currentFamily = "";
		File currentPogFile;
		
		for(int i = 0; i < families.size(); i++){
			currentFamily = families.get(i).trim();
			
			for(int pogNumber = 0; pogNumber < MAX_POG_COUNT; pogNumber++){
				String pogName = "Cluster" + pogNumber;
				
				currentPogFile = new File("/Users/andrey/Documents/Sefma/h/maxshats/Projects/TFmotif/SEFMA_5_10_30/" + currentFamily + "/Cluster/" + pogName);

				if(currentPogFile.exists()){
					runThroughSites(currentPogFile);
				}
			}
		}

	}
	
	private static void runThroughSites(File currentPogFile) {
		// TODO Auto-generated method stub
		
	}

	public static BufferedReader createBR(String fileLocation) throws IOException{
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(new FileInputStream(fileLocation)));
		return br;
	}
}