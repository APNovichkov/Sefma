package com.apn.sefma;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class SeparateFamilyAndDomain {

	static String fileLocation = "/Users/andrey/Documents/Sefma/tffamilies_rules.txt";
	static StringBuffer familyName = new StringBuffer("");
	static StringBuffer domainName = new StringBuffer("");
	static StringBuffer TFFamily2Domain = new StringBuffer("");
	
	static int familyId = 1;
	static int domainId = 1;
	
	static int lineCount = 0;
	
	static Hashtable<String,Integer> hash = new Hashtable<String,Integer>();
	
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = createBF();
		parseFile(br);
//		printFamilyNames`();
		
//		familyName.replaceAll(" \t", "");
		
		save2File(familyName, "familyName");
//		save2File(domainName, "domainName");
//		save2File(TFFamily2Domain, "TFFamily2Domain");
		
	}
	
	
	
	private static void test2() {
		Hashtable<String,Integer> hash = new Hashtable<String,Integer>(); 
		
		int domainId = 0;
		
		String domainName1 = "PF1111";
		hash.put(domainName1, domainId);
		
		String domainName2 = "PF1111";
		if( hash.containsKey(domainName2) ){
			System.out.println("Hash already has key = " + domainName2);
		}
		
		
		String domainName3 = "PF33333";
		domainId ++;
		hash.put(domainName3, domainId);
		
		System.out.println("The value of the key " + domainName1 + " = " + hash.get(domainName1));
		System.out.println("The value of the key " + domainName3 + " = " + hash.get(domainName3));
		
		
		
	}



	private static void test1() {
//		String s = "asd  \twewer  \t\t ewwre";
		String s = "asd  \twewer  \t\t ewwre";

		
		StringTokenizer tkn = new StringTokenizer(s, " \t");
		System.out.println("Number of tokens = " + tkn.countTokens());
		
		while(tkn.hasMoreTokens()){
			System.out.println(tkn.nextToken());
		}
		
	}



	
	
	
	public static BufferedReader createBF() throws IOException{
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(new FileInputStream(fileLocation)));
		return br;
	}

	public static void parseFile(BufferedReader br) throws IOException{
		try {
			String line;
			
			while ((line = br.readLine()) != null) {
				StringTokenizer tkn = new StringTokenizer(line, " \t");
				
				parseLine(tkn, line);
			
		    }
		} finally {
		    br.close();
		}
		
	}
	
	public static void parseLine(StringTokenizer tkn, String line){
		int lineElementCount = 0;
		int domainCount = 0;
		
		int currentFamilyId= 0;
		int[] currentDomainId = new int[3];
		
		while(tkn.hasMoreTokens()){
			System.out.println("I have more tokens");
			if(lineElementCount == 0){
				String currentToken = tkn.nextToken();
				currentFamilyId = familyId;
				
				fillFamilyNames(currentToken, familyId);
				
				lineElementCount++;
				familyId++;
			}else{
				String currentToken = tkn.nextToken();
				
				if(hash.containsKey(currentToken)){
					currentDomainId[domainCount] = hash.get(currentToken); 
				}else{
					fillDomainNames(currentToken, domainId);
					hash.put(currentToken, domainId);
					
					currentDomainId[domainCount] = hash.get(currentToken);
					
					domainId++;
				}
				
				domainCount++;
				lineElementCount++;
			}
		}
		
		fillFamily2Domain(currentDomainId);
		
		
		
	}
	
	public static void fillFamilyNames(String currentToken, int familyId){
		familyName.append(familyId + ", ");
		familyName.append(currentToken + ", ");
		familyName.append(1000 + ", ");
		familyName.append(100 + ", ");
		familyName.append(50 + ", ");
		familyName.append(30 + ", ");
		familyName.append(10 + ", ");
		familyName.append("Description");
		
		familyName.append("\n");
	}
	
	public static void fillDomainNames(String currentToken, int domainId){
		domainName.append(domainId + ", ");
		domainName.append(currentToken);
		domainName.append("\n");
	}
	
	public static void fillFamily2Domain(int[] currentDomainId){
		
		
		for(int i = 0; i < currentDomainId.length; i++){
			if(currentDomainId[i] == 0){
				
			}else{
				TFFamily2Domain.append(familyId + ", ");
				TFFamily2Domain.append(currentDomainId[i]);
				TFFamily2Domain.append("\n");
			}
			
		}
		
		
	}
	
	public static void printFamilyNames(){
		System.out.println(TFFamily2Domain);
	}
	
	
	
	public static void save2File(StringBuffer output, String fileName) throws FileNotFoundException{
		PrintWriter out = new PrintWriter("/Users/andrey/Documents/Sefma/" + fileName + ".txt");  
		out.println(output);
		out.close();
		
	}
}
