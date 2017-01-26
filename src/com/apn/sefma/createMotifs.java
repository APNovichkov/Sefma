package com.apn.sefma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

public class createMotifs {
	static final int MAX_POG_COUNT = 1000;
	static final int MAX_MOTIF_COUNT = 20;
	static final int MAX_BYTE_COUNT = 8;
	
	public static final int BYTE_SIZE = 8;
	
	private static final int LETTER_INDEX_MAX = 256;
	
	static final int[] DNA_CONVERTER = new int[LETTER_INDEX_MAX];
	static{
		DNA_CONVERTER['A'] = 0;
		DNA_CONVERTER['T'] = 1;
		DNA_CONVERTER['C'] = 2;
		DNA_CONVERTER['G'] = 3;
		DNA_CONVERTER['a'] = 0;
		DNA_CONVERTER['t'] = 1;
		DNA_CONVERTER['c'] = 2;
		DNA_CONVERTER['g'] = 3;
	}
	
	static Vector<String> families;
	static String familyNamesLocation = "/Users/andrey/Documents/Sefma/familyName.txt";
	
	
	static StringBuffer motifs = new StringBuffer("");
	
	static int motifId = 1;
	
	public static void main(String[] args) throws IOException {
		fillFamilies(createBR(familyNamesLocation));
		
		runThroughClusters();

		System.out.println(motifs);
		
		save2File(motifs, "motif");
		
		System.out.println("File Saved Sucessfully");
		
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
					fillMotifs(currentPogFile);
				}
			}
		}
	}

	private static void fillMotifs(File currentPogFile) throws IOException {
		File currentMotifFile;
		BufferedReader br;
		
		for(int i = 1; i < MAX_MOTIF_COUNT; i++){
			String siteName = i + ".sites";
			
			currentMotifFile = new File(currentPogFile.getPath() + "/" + siteName);
			
			if(currentMotifFile.exists()){
				br = createBR(currentMotifFile.getPath());
				
//				System.out.println(currentMotifFile.getPath());
				readMotifs(br);
			}
		}
	}
	
	private static void readMotifs(BufferedReader br) throws IOException {
		String line;
		boolean isLocusId = false;
		
		while((line = br.readLine()) != null){
			if(line.charAt(0) == '>'){
				isLocusId = true;
			}else{
				isLocusId = false;
			}
			
			readLine(line, isLocusId);
		}
		
	}

	private static void readLine(String line, boolean isLocusId) {
		String[] tokens;
		int locusId = 0;
		byte[] motifByteSequence = new byte[MAX_BYTE_COUNT];
		String sequence = "";
		
		if(isLocusId == true){
			tokens = line.split("_");
			locusId = Integer.parseInt(tokens[1].trim());
			motifs.append(motifId + ", ");
			motifs.append(locusId + ", ");
			
			motifId++;
		}else{
//			System.out.println("This is the line that will get passed to the Dna2Decimal method: " + line);
			motifByteSequence = dna2Decimal(line);
			for(int i = 0; i < motifByteSequence.length; i++){
				sequence += decimalToBinary(motifByteSequence[i]);
			}
			motifs.append(line + "\n");
			 
		}
		
	}

	public static byte[] dna2Decimal(String dna){
		int byteArraySize = (int) Math.ceil((1f*dna.length()/4));
		
		byte[] output = new byte[byteArraySize];
//		System.out.println(byteArraySize);
		for(int i = 0, byteIndex = 0; i < dna.length(); i++){
			char currentLetter = dna.charAt(i);
			byteIndex = i / 4;
			output[byteIndex] <<=2;
			output[byteIndex] += DNA_CONVERTER[currentLetter];
		}
		return output;		
		
		
	}
	
	public static String decimalToBinary(byte value){
		String output = "";
		byte pattern = (byte) (1<< (BYTE_SIZE-1));
		
		for(int i = 0 ; i < BYTE_SIZE; i++){
			output += (value & pattern) == 0 ? "0" : "1";
			value <<= 1;
		}
		
		return output;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static BufferedReader createBR(String fileLocation) throws IOException{
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(new FileInputStream(fileLocation)));
		return br;
	}
	
	public static void save2File(StringBuffer output, String fileName) throws FileNotFoundException{
		PrintWriter out = new PrintWriter("/Users/andrey/Documents/Sefma/" + fileName + ".txt");  
		out.println(output);
		out.close();
	}
	
}
