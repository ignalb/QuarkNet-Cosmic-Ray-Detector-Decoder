package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DataController {

	private static final String dat_PATH = "src/main/resources/";	//TODO makes this its own class
	private static File dat;
	private static String date;
	private static int count;
	private FileWriter write;
	
	public DataController() throws IOException{
		Scanner in = new Scanner(System.in);
		boolean isValid = false;
		
		do{
			dat = new File(dat_PATH + "info.dat");
			try {
				in = new Scanner(dat);
				isValid = true;
			} catch (FileNotFoundException e) {
				date = DataParser.timeToStringDate(Files.readAttributes(dat.toPath(), BasicFileAttributes.class).lastModifiedTime());
				count = 0;
				update();
			}
		} while(!isValid);
		
		//Reads file and updates variables
		date = in.nextLine();
		count = in.nextInt();
		
		in.close();
	}
	
	public int getCount() throws IOException{
		String currentDate = DataParser.timeToStringDate(LocalDateTime.now().toString());
		count = (date.equals(currentDate)) ? ++count : 1;
		update();
		return count;
	}
	
	private void update(){
		try{
			write = new FileWriter(dat);
			write.write(date + "\n");
			write.write(count + "\n");
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
