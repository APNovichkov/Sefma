package com.apn.exercises;

public class BitOperations {

	public static final int BYTE_SIZE = 8;
	
	private static final int CODE_ZERO = 48;
	
	private static final int LETTER_INDEX_MAX = 256;
	
	private static final int DNA_IN_BYTE_COUNT = 4;
	
	
	
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
	
	static final char[] CHAR_CONVERTER = new char[4];
	static{
		CHAR_CONVERTER[0] = 'A';
		CHAR_CONVERTER[1] = 'T';
		CHAR_CONVERTER[2] = 'C';
		CHAR_CONVERTER[3] = 'G';
	}

	public static void main(String[] args) {

//		System.out.println("This is the binary code: " + decimalToBinary((byte) 5));
		byte[] a = dnaToByte("ATCCAAAA");
		System.out.println(byteToDna(a));
		System.out.println("Length:" + a.length);
		
		for(int i = 0; i < a.length; i++){
			
		}
//			System.out.println(decimalToBinary(a[i]));
	}
	public static long binaryToDecimal(String binary){
		long output = 0;
		int bitPower = 0;
		
		for(int i = binary.length() - 1; i >= 0; i--){
			if(binary.charAt(i) == '1'){
				output += Math.pow(2, bitPower);
			}
			bitPower++;
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
	
	public static byte[] dnaToByte(String dna){
		byte[] output = new byte[(dna.length()/4)];
		for(int i = 0, byteIndex = 0; i < dna.length(); i++){
			char currentLetter = dna.charAt(i);
			byteIndex = i / 4;
			output[byteIndex] <<=2;
			output[byteIndex] += DNA_CONVERTER[currentLetter];
		}
		return output;		
	}
	
	public static String byteToDna(byte[] dna){
		String output = "";
		byte alignment = (byte) 3;
		
				
		for(int i = 0; i < dna.length; i++){
			byte currentByte = dna[i];
			System.out.println("The current byte at byteIndex " + i + " is: " + decimalToBinary(dna[i]));
			
			byte byteSegment;
			
			for(int j = DNA_IN_BYTE_COUNT - 1; j >= 0 ; j--){
				byteSegment = (byte) (alignment&  (currentByte >> j*2) );
				output += CHAR_CONVERTER[byteSegment];
			}
		}
		
		return output;
	}
	
	
	
	public static byte[] p_dnaToByte(String dna){
		byte[] output = new byte[(dna.length()/4)];
		
		int byteIndex = 0;
		int bposIndex = 0;
		for(int i = 0; i < dna.length(); i++){
			byteIndex = i / 4;
			bposIndex = i % 4;
			int code = dna.charAt(i);
			output[byteIndex] += (DNA_CONVERTER[code] << ( (3 - bposIndex)*2 ) ); 			
		}
		return output;
	}
	
	public static String reverseString(String input){
		String output = "";
		
		for(int i = input.length(); i < 0; i++){
			
		}
		
		return output;
	}
	
	
	
}
