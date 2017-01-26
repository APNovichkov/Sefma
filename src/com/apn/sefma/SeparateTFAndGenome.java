package com.apn.sefma;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

public class SeparateTFAndGenome {

	static Vector<String> families;

	static String familyNamesLocation = "/Users/andrey/Documents/Sefma/familyName.txt";
	static String genomeNamesLocation = "/Users/andrey/Documents/Sefma/speciesList.txt";
	static String currentFileLocation = "";
	
	static Hashtable<String,Integer> genomeHash = new Hashtable<String,Integer>();
	static Hashtable<String,Integer> familyHash = new Hashtable<String,Integer>();
	
	static StringBuffer transcriptionFactor = new StringBuffer("");
	static StringBuffer genome = new StringBuffer("");
	
	static int transcriptionFactorId = 1;
	
	static int tfsLineCount = 0;
	  
	public static void main(String[] args) throws IOException {
		
		fillFamilies(createFamiliesBR());
		
		createGenomeHash();
		
		circleThroughFamilies();
		
//		save2File(transcriptionFactor, "transcriptionFactor");
		System.out.println("File saved successfully");
		
		System.out.println("Amount of tfs: " + tfsLineCount);
	}
	
	
	public static void fillFamilies(BufferedReader br) throws IOException{
		families = new Vector<String>();
		try {
			for(String line = br.readLine(); line != null; line = br.readLine()){
				line.trim();
				if(line.length() == 0) continue;
				
				String[] tokens = line.split(",");
				String familyName = tokens[1].trim();
				int familyId = Integer.parseInt(tokens[0].trim());
				
				familyHash.put(familyName, familyId);
		
				families.add(familyName);
			}
		} finally {
			br.close();
		}
	}
	
	public static void createGenomeHash() throws IOException{
		BufferedReader br = createGenomeBR();
		
		String key = "";
		int value = 0;
		
		try{
			for(String line = br.readLine(); line != null; line = br.readLine()){
				line.trim();
				if(line.length() == 0) continue;
				
				String[] tokens = line.split("\t");
				value = Integer.parseInt(tokens[0]);
				key = tokens[1];
				
				genomeHash.put(key, value);
			}
		}finally{
			addOtherGenomes();
			br.close();
		}
	}
	
	

	public static void circleThroughFamilies() throws IOException{
		HashSet<String> missingGenomes = new HashSet<String>();
		
		
		
		for(String family: families){
			String fileName = "/Users/andrey/Documents/Sefma/h/maxshats/Projects/TFmotif/SEFMA_5_10_30/" + family+ "/tfs";
			
			BufferedReader br = new BufferedReader(new FileReader(fileName));			
			
			for(String line = br.readLine(); line != null; line = br.readLine()){
				String[] tokens = line.split("\t");
				
				if(tokens.length > 2){
					String genomeName = tokens[2];
					
					if( !genomeHash.containsKey(genomeName) ){
						missingGenomes.add(genomeName);
					}
				}
				if(tokens[0] == null){
					System.out.println("Token[0] is null");
				}
				
				parseLine(tokens, family);
			}
			
			br.close();
		}
		
		
		System.out.println("Missing genomes:");
		for(String mg: missingGenomes){
			System.out.println(mg);
		}
		System.out.println("----- number of missing genomes = " + missingGenomes.size());
		
		
	}

	private static void parseLine(String[] tokens, String familyName) {
		String locusId;
		String transcriptionFactorName;
		String genomeName;
		int familyId;
		
		
		locusId = tokens[0];
		transcriptionFactorName = tokens[1].trim();
		genomeName = tokens[2].trim();
		familyId = familyHash.get(familyName);
		
		
		int taxId = genomeHash.get(genomeName);
		
		transcriptionFactor.append(locusId + ", ");
		transcriptionFactor.append(transcriptionFactorName + ", ");
		transcriptionFactor.append(taxId + ", ");
		transcriptionFactor.append(familyId);
		transcriptionFactor.append("\n");
		tfsLineCount++;
	}	
	

	public static BufferedReader createGeneAndGenomeBR() throws FileNotFoundException{
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(new FileInputStream(currentFileLocation)));
		return br;
	}
	
	public static BufferedReader createFamiliesBR() throws IOException{
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(new FileInputStream(familyNamesLocation)));
		
//		return new BufferedReader(new FileReader(familyNamesLocation));
	
		
		return br;
	}
	
	public static BufferedReader createGenomeBR() throws IOException{
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(new FileInputStream(genomeNamesLocation)));
		return br;
	}
	
	public static void save2File(String output, String fileName) throws FileNotFoundException{
		PrintWriter out = new PrintWriter("/Users/andrey/Documents/Sefma/" + fileName + ".txt");  
		out.println(output);
		out.close();
		
	}
	
	public static void save2File(StringBuffer output, String fileName) throws FileNotFoundException{
		PrintWriter out = new PrintWriter("/Users/andrey/Documents/Sefma/" + fileName + ".txt");  
		out.println(output);
		out.close();
		
	}
	
	
	
	
	
	
	private static void addOtherGenomes() {
		genomeHash.put("Staphylococcus aureus, N315", 158879);
		genomeHash.put("Lactobacillus salivarius saliv. UCC118", 362948);
		genomeHash.put("Listeria welshimeri serovar 6b SLCC5334", 386043);
		genomeHash.put("Syntrophomonas wolfei wolfei Goettingen", 335541);
		genomeHash.put("Aeromonas hydrophila hydro. ATCC 7966", 380703);
		genomeHash.put("Wolbachia endosymbiont, Drosophila", 163164);
		genomeHash.put("Lactobacillus delbrueckii bulg. 11842", 390333);
		genomeHash.put("Staphylococcus epidermidis", 176280);
		genomeHash.put("Bacillus thuringiensis str. 97-27", 281309);
		genomeHash.put("Leuconostoc mesenteroides mesent. 8293", 203120);
		genomeHash.put("Photorhabdus luminescens TTO1", 243265);
		genomeHash.put("Agrobacterium tumefaciens C58", 176299);
		genomeHash.put("Cand. Pelagibacter ubique HTCC1062", 335992);
		genomeHash.put("Buchnera aphidicola str. Bp", 224915);
		genomeHash.put("Buchnera aphidicola str. APS", 107806);
		genomeHash.put("Cand. Blochmannia pennsylvanicus BPEN", 291272);
		genomeHash.put("Buchnera aphidicola str. Sg", 198804);
		genomeHash.put("Mycoplasma capricolum ATCC 27343", 340047);
		genomeHash.put("Saccharophagus degradans", 203122);
		genomeHash.put("Xanthomonas campestris ATCC 33913", 190485);
		genomeHash.put("Leptospira interrogans, 56601", 189518);
		genomeHash.put("Leptospira borgpetersenii H-b L550", 355276);
		genomeHash.put("Fusobacterium nucleatum, ATCC25586", 190304);
		genomeHash.put("Baumannia cicadellinicola str. Hc", 374463);
		genomeHash.put("Buchnera aphidicola str. Cc", 372461);
		genomeHash.put("Legionella pneumophila str Phil. 1", 272624);
		genomeHash.put("Pelobacter carbinolicus DSM 2380", 338963);
		genomeHash.put("Desulfovibrio desulfuricans ATCC 27774", 525146);
		genomeHash.put("Wolbachia endosymbiont, TRS", 292805);
		genomeHash.put("Cand. Blochmannia floridanus", 203907);
		genomeHash.put("Prochlorococcus marinus, SS120", 167539);
		genomeHash.put("Wigglesworthia glossinidia", 36870);
		genomeHash.put("Pseudomonas syringae", 223283);
		genomeHash.put("Xanthomonas axonopodis", 190486);
	}
}
