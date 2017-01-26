package com.apn.sefma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Vector;

public class CreatePogs {
	
	static final int MAX_POG_COUNT = 1000;
	
	static Vector<String> families;
	static String familyNamesLocation = "/Users/andrey/Documents/Sefma/familyName.txt";
	
	static StringBuffer pog = new StringBuffer("");
	static StringBuffer pog2Tfs = new StringBuffer("");
	
	
	public static void main(String[] args) throws IOException {
		fillFamilies(createFamiliesBR());
		
		fillPog();
		
		save2File(pog, "pog");
		save2File(pog2Tfs, "pog2tfs");

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
	
	public static void fillPog() throws IOException{
		String currentFamily = "";
		File currentPogFile;
		
		int pogId = 0;
		
		for(int i = 0; i < families.size(); i++){
			currentFamily = families.get(i).trim();
			
			for(int pogNumber = 0; pogNumber < MAX_POG_COUNT; pogNumber++){
				String pogName = "Cluster" + pogNumber;
				
				currentPogFile = new File("/Users/andrey/Documents/Sefma/h/maxshats/Projects/TFmotif/SEFMA_5_10_30/" + currentFamily + "/Cluster/" + pogName);

				if(currentPogFile.exists()){
					pog.append(pogId + ", ");					
					pog.append(pogName + ", ");
					pog.append(currentPogFile.getPath() + "\n");
					
					fillPog2Tfs(currentPogFile, pogId);
					fillMotifs(currentPogFile, pogId);
					
					pogId++;
				}
			}
		}
	}
	
	public static void fillPog2Tfs(File currentPogFile, int pogId) throws IOException {
		File currentPogTfsFile = new File(currentPogFile.getPath() + "/tfs");
		
		BufferedReader br = new BufferedReader(new FileReader(currentPogTfsFile.getPath()));
		
		String line = br.readLine();
		
		String[] tokens = line.split(" ");
		
		pog2Tfs.append(tokens[1].trim() + ", ");
		pog2Tfs.append(pogId + "\n");
	}
	
	public static void fillMotifs(File currentPogFile, int pogId){
		
	}
	

	public static BufferedReader createFamiliesBR() throws IOException{
		return new BufferedReader(new FileReader(familyNamesLocation));
	}

	public static void save2File(StringBuffer output, String fileName) throws FileNotFoundException{
		PrintWriter out = new PrintWriter("/Users/andrey/Documents/Sefma/" + fileName + ".txt");  
		out.println(output);
		out.close();
	}
	
}
