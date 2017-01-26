package com.apn.sefma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Vector;

public class DataCenter {
	
	final static int MAX_POG_COUNT = 1000;
	final static int MOTIF_COUNT_PER_POG = 5;
	
	static Hashtable<String,Integer> genomeHash = new Hashtable<String,Integer>();

	static Vector<TFFamily> tffamilies = new Vector<TFFamily>();
	static Vector<Domain> domains = new Vector<Domain>();
	static Vector<TFFamily2Domain> tfs2domain = new Vector<TFFamily2Domain>();
	static Vector<Pog> pogs = new Vector<Pog>();
	static Vector<Motif> motifs = new Vector<Motif>();
	static Vector<Genome> genomes = new Vector<Genome>();
	static Vector<TranscriptionFactor> tfs = new Vector<TranscriptionFactor>();
	static Vector<Tfs2Pog> tfs2pog = new Vector<Tfs2Pog>();
	static Vector<Site> sites = new Vector<Site>();
 	
	//File Locations
	static String tffamilyAndDomainFile = "/Users/andrey/Documents/Sefma/tffamilies_rules.txt";
	static String genomeNamesFile = "/Users/andrey/Documents/Sefma/speciesList.txt";
	
	public static void main(String[] args) throws IOException {
		fillTFFamilyNameIdAndDomainNameIdAndConnector(createBR(tffamilyAndDomainFile));
		fillPogIdNameAndTFFamilyStatsAndMotifsAndSites();
	
		fillGenomeIdNameAndTfsAndTfs2Pog();
		
		
//		for(int i = 0; i < tffamilies.size(); i++){
//			System.out.println("Genome Count for Family " + tffamilies.get(i).getFamilyName() + " is: " + tffamilies.get(i).getGenomeCount());
//		}
	}
	
	
	public static void fillTFFamilyNameIdAndDomainNameIdAndConnector(BufferedReader br) throws IOException{
		int tffamilyId = 0;
		int domainId = 0;
		
		String[] tokens;
		String line = "";
		
		Hashtable<String,Integer> domainHash = new Hashtable<String,Integer>();
		
		while((line = br.readLine())!=null){
			tffamilies.add(new TFFamily());
			
			tokens = line.split("\t");
			
			
			
			tffamilies.get(tffamilyId).setFamilyId(tffamilyId);
			tffamilies.get(tffamilyId).setFamilyName(tokens[0].trim());
			
			for(int i = 1; i < tokens.length; i++){
				String currentDomainName = tokens[i].trim();
				int currentDomainId = 0;
				
				if(domainHash.containsKey(currentDomainName)){
					currentDomainId = domainHash.get(currentDomainName);
				}else{
					currentDomainId = domainId;
					domainHash.put(currentDomainName, currentDomainId);
					domains.add(new Domain(currentDomainId, currentDomainName));
				}
				
				tfs2domain.add(new TFFamily2Domain(tffamilyId, currentDomainId));
				
				domainId++;
			}
			tffamilyId++;
		}
		br.close();
		
	}
	
	public static void fillPogIdNameAndTFFamilyStatsAndMotifsAndSites() throws IOException{
		String currentFamilyName = "";
		File currentPogFile;
		
		int pogId = 0;
		int siteId = 0;
		
		for(int i = 0; i < tffamilies.size(); i++){
			int pogCountPerFamily = 0;
			int motifCountPerFamily = 0;
			
			int motifId = 0;
			
			currentFamilyName = tffamilies.get(i).getFamilyName();
			
			for(int pogNumber = 0; pogNumber < MAX_POG_COUNT; pogNumber++){
				String pogName = "Cluster" + pogNumber;
				
				currentPogFile = new File("/Users/andrey/Documents/Sefma/h/maxshats/Projects/TFmotif/SEFMA_5_10_30/" + currentFamilyName + "/Cluster/" + pogName);

				if(currentPogFile.exists()){
					pogs.add(new Pog(pogId, pogName, currentPogFile.getPath()));
					
					for(int j = 1; j <= MOTIF_COUNT_PER_POG; j++){
						File motifFile = new File(currentPogFile.getPath() + "/" + j + ".sites");
						
						if(motifFile.exists()){
							motifs.add(new Motif(motifId, pogId, j));
							
							BufferedReader siteBr = createBR(motifFile.getPath());
							
							String line;
							boolean isLocusId = false;
							int locusId = 0;
							
							while((line = siteBr.readLine()) != null){
								if(line.charAt(0) == '>'){
									isLocusId = true;
								}else{
									isLocusId = false;
								}
								
								String[] tokens;
								
								String sequence = "";
								
								
								if(isLocusId == true){
									tokens = line.split("_");
									locusId = Integer.parseInt(tokens[1].trim());
								}else{
									sequence = line;
									sites.add(new Site(siteId, locusId, sequence, motifId));
									siteId++;
								}
								
							}
							
							
							motifCountPerFamily++;
						}
						
						motifId++;
					}
					pogCountPerFamily++;
					pogId++;
				}
			}
			
			tffamilies.get(i).setPogCount(pogCountPerFamily);
			tffamilies.get(i).setMotifCount(motifCountPerFamily);
		}
	}
	
	public static void fillGenomeIdNameAndTfsAndTfs2Pog() throws IOException{
		BufferedReader genomeBR = createBR(genomeNamesFile);
		
		String key = "";
		int value = 0;
		
		try{
			for(String line = genomeBR.readLine(); line != null; line = genomeBR.readLine()){
				line.trim();
				if(line.length() == 0) continue;
				
				String[] tokens = line.split("\t");
				value = Integer.parseInt(tokens[0]);
				key = tokens[1];
				
				genomeHash.put(key, value);
				genomes.add(new Genome(value, key));
			}
		}finally{
			addOtherGenomes();
			genomeBR.close();
		}
		
		int transcriptionFactorId = 0;
		
		Hashtable<Integer, Integer> pogLocusHash = new Hashtable<Integer, Integer>();
		
		for(int i = 0; i < tffamilies.size(); i++){
			
			for(int pogId = 0; pogId < tffamilies.get(i).getPogCount(); pogId++){
				int clusterNumber = pogId + 1;
				File pogTfs = new File("/Users/andrey/Documents/Sefma/h/maxshats/Projects/TFmotif/SEFMA_5_10_30/" + tffamilies.get(i).getFamilyName() + "/Cluster/" + "Cluster" + clusterNumber + "/tfs");				
				
				BufferedReader pogTfsBr = createBR(pogTfs.getPath());
				
				try{
					for(String line = pogTfsBr.readLine(); line != null; line = pogTfsBr.readLine()){
						if(line.startsWith(">")){
							String[] tokens = line.split(" ");
							int locusId = Integer.parseInt(tokens[1]);
							pogLocusHash.put(locusId, pogId);
							
						}
					}
				}finally{
					pogTfsBr.close();
					
				} 
			}
			
			
			
			
			File tfsFile = new File("/Users/andrey/Documents/Sefma/h/maxshats/Projects/TFmotif/SEFMA_5_10_30/" + tffamilies.get(i).getFamilyName()+ "/tfs");
			BufferedReader br = createBR(tfsFile.getPath());		
		
			int tfsPerFamily = 0;
			
			Hashtable<String, Integer> genomePerFamilyCountHash = new Hashtable<String, Integer>();
			int genomesPerFamilyCount = 0;
			
			for(String line = br.readLine(); line != null; line = br.readLine()){
				String[] tokens = line.split("\t");
				
				int locusId = Integer.parseInt(tokens[0].trim());
				String transcriptionFactorName = tokens[1].trim();
				String genomeName = tokens[2].trim();
				int familyId = tffamilies.get(i).getFamilyId();
				int taxonomyId = genomeHash.get(genomeName);
				
				if(!genomePerFamilyCountHash.containsKey(genomeName)){
					genomePerFamilyCountHash.put(genomeName, genomesPerFamilyCount);
					genomesPerFamilyCount++;
				}
				
				tfs.add(new TranscriptionFactor(transcriptionFactorId, taxonomyId, locusId, transcriptionFactorName, familyId));
				
				tfsPerFamily++;
			}
			
			br.close();
			
			
			
			
			
			tffamilies.get(i).setTfsCount(tfsPerFamily);
			tffamilies.get(i).setGenomeCount(genomesPerFamilyCount);
		}
		
		System.out.println("pogLocusHash size: " + pogLocusHash.size());
		
		for(int j = 0; j < tfs.size(); j++){
			int tfsLocusId = tfs.get(j).getLocusId();
			Integer pogId = pogLocusHash.get(tfsLocusId);
			
			if(pogId != null){
				tfs2pog.add(new Tfs2Pog(pogLocusHash.get(tfsLocusId), tfs.get(j).getTranscriptionFactorId()));
//				System.out.println("tfs2pog file created with this pogId:" + pogLocusHash.get(tfsLocusId));
			}
		}
		
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
