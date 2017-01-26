package com.apn.exercises;

import java.io.File;

public class FileOperations {

	static File f;
	static String phrase = "I AM SO FUCKING HAPPY";
	
	public static void main(String[] args) {
		makeLounesUnderstand();
	}
	
	public static void makeLounesUnderstand(){
		talkForTime(1);
		giveHimFood(20);
		getStoned(24);
		say(phrase);
	}
	
	
	private static void say(String phrase) {
		System.out.println(phrase);
		
	}

	private static void getStoned(int time) {
		System.out.println("Lounes got stoned for this much time: " + time);
	}

	private static void giveHimFood(int amountOfFood) {
		System.out.println("Gave lounes this much food: " + amountOfFood);
	}

	private static void talkForTime(int time) {
		System.out.println("Talked for time: " + time);
		
	}

	
	

	public static void showDirectoryStructure(){
		f = new File("/Users/andrey/Documents/Sefma/h/maxshats/Projects/TFmotif/SEFMA_5_10_30/TetR/Cluster");
		
		if(!f.exists()){
			System.out.println("File does not exist");
		}
		
		for(File file: f.listFiles()){
			if(file.isDirectory()){
				System.out.println("This file is a directory and its name is: " + file.getName() + "\t" + file.getAbsolutePath());
			}else{
				System.out.println("This file is a file and its name is: " + f.getName());
			}
			
			
		}
	}
	
	
	
	
}
