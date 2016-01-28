package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataController {

	private static final String dat_PATH = "src/main/resources/";	//TODO makes this its own class
	private static File dat;
	private static String date;
	private static int count;
	
	public DataController(){
		Scanner in = new Scanner(System.in);
		boolean isValid = false;
		do{
			try {
				in = new Scanner(dat);
				isValid = true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				dat = new File(dat_PATH + "info.dat");
				//TODO Init file
			}
		} while(!isValid);
		date = in.next();	//TODO change to pattern equivalent to "yyyy-mm-dd" or just change to nextLine()
		
	}
	
	public static int getCount(){
		return count;
	}
	
}
