package main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Scanner;

public class DataParser {

	private static final String EXT = "csv";
	private ArrayList<DataStorage> data = new ArrayList<DataStorage>();
	private String[] buffer;
	
	public DataParser(File read){
		File write;
		FileWriter writer;
		Scanner reader;
		
		try {
			String filename = timeToStringDate(Files.readAttributes(read.toPath(), BasicFileAttributes.class).lastModifiedTime())
					+ "_" + String.format("%03d", new DataController().getCount()) + "." + EXT;
			Debug.println("Writer filename = " + filename);
			write = new File(filename);
			reader = new Scanner(read);
			writer = new FileWriter(write);
			//TODO REDO this so that the String[] buffer is not needed. (In a smart way) make Scanner radix 16 when needed.
			//TODO when an ST is set create a new DataStorage of right type
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
	public static String timeToStringDate(java.nio.file.attribute.FileTime t){
		return timeToStringDate(t.toString());
	}
	
	public static String timeToStringDate(String time){
		return time.substring(0, 10);
	}
}
