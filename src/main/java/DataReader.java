package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InvalidObjectException;

public class DataReader {

	public DataReader(File f) throws InvalidObjectException, FileNotFoundException{
		String filename = f.getName();
		if(!filename.substring(filename.lastIndexOf('.'), filename.length()).equals(".txt"))
			throw new InvalidObjectException(filename);
	}
	
}
