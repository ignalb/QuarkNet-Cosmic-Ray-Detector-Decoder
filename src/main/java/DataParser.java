package main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class DataParser {

	private static final String EXT = "csv";
	private String[] buffer;
	
	public DataParser(File read){
		File write;
		FileWriter writer;
		Scanner reader;
		
		try {
			write = new File(timeToDateString(Files.readAttributes(read.toPath(), BasicFileAttributes.class).lastModifiedTime()) + "." + EXT);
			//TODO include file number for ^. Should be in format: "yyyy-mm-dd_xxx.csv"; as of now: "yyyy-mm-dd.csv"
			//TODO implement a .dat file to keep track of 1. date 2. count for that day; also make method to keep track of this
			reader = new Scanner(read);
			writer = new FileWriter(write);
			while(reader.hasNext()){
				buffer = readToBuffer(reader);
				parse(buffer, writer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void parse(String[] s, FileWriter f) {
		
	}
	
	public String[] readToBuffer(Scanner in){
		
		return null;
	}
	
	/**
	 * Receives a file's time metadata and returns the date as a String
	 * @param t Time Stamp
	 * @return Date as a String
	 */
	private String timeToDateString(java.nio.file.attribute.FileTime t){
		String date = t.toString();
		return date.substring(0, 10);
	}
}
