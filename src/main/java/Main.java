package main.java;

import java.io.File;

public class Main {

	public static File file;		// filename to write to
	private static File fileRead;	// filename to read (if given)
	
	/**
	 * @param args <ul>
	 * 		<li><em>file_name.txt</em> in current path containing raw data</li> <ul><li>ex: data01261601.txt</li></ul>
	 * 		<li><em>file_path/file_name.txt</em> containing raw data</li> <ul><li>ex: C:\Users\<em>user</em>\Desktop\data01261601.txt</li></ul>
	 * 		<li>Direct raw data from zTerm or HyperText</li> <ul><li>__</li></ul> </ul>
	 * 			//TODO Check names of programs and fix if needed
	 * 			//TODO provide sample data
	 */
	public static void main(String[] args){
		
		argTypes argType = getArgType(args);
		
		switch(argType){
			case FILE_LOCAL:
				
				break;
			case FILE_PATH:
				
				break;
			case DATA_RAW:
				
				break;
			case ERROR:
				//TODO ask for user input and rerun getArgType
		}
		
	}
	
	private static argTypes getArgType(String[] args){
		//TODO method
		return argTypes.ERROR;
	}
	
}

enum argTypes {
	FILE_LOCAL, FILE_PATH, DATA_RAW, ERROR
}