package com.apn.sefma;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ModifySpeciesListFile {

	static String genomeNamesLocation = "/Users/andrey/Documents/Sefma/speciesList.txt";
	static String speciesList = "";
	
	
	public static void main(String[] args) throws IOException {
		parseLine(createGenomeBR());
		System.out.println(speciesList);
		save2File(speciesList, "speciesList");
		System.out.println("Files Saved Successfully");
	}
	
	public static BufferedReader createGenomeBR() throws IOException{
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(new FileInputStream(genomeNamesLocation)));
		return br;
	}
	
	public static void parseLine(BufferedReader br) throws IOException{
		
		String line = "";
		
		
		try{
			while((line = br.readLine()) != null){
				int tokenCount = 0;
				StringTokenizer tkn = new StringTokenizer(line, ",");
				
				while(tkn.hasMoreTokens()){
					String currentToken = tkn.nextToken();
					currentToken = currentToken.replaceAll("\"", "");
					
					if(tokenCount == 0){
						speciesList += currentToken + "\t";
						tokenCount++;
					}else{
						speciesList += currentToken;
					}
				}
				
				speciesList += "\n";
				
			}
		}finally{
			br.close();
		}
		
	}
	
	public static void save2File(String output, String fileName) throws FileNotFoundException{
		PrintWriter out = new PrintWriter("/Users/andrey/Documents/Sefma/" + fileName + ".txt");  
		out.println(output);
		out.close();
		
	}

}
