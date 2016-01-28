package main.java;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	/**
	 * @param args <ul>
	 * 		<li><em>file_name.txt</em> in current path containing raw data</li> <ul><li>ex: data01261601.txt</li></ul>
	 * 		<li><em>file_path/file_name.txt</em> containing raw data</li> <ul><li>ex: C:\Users\<em>user</em>\Desktop\data01261601.txt</li></ul>
	 * 		<li>Direct raw data from zTerm or HyperText</li> <ul><li>__</li></ul> </ul>
	 * 			//TODO Check names of programs and fix if needed
	 * 			//TODO provide sample data
	 */
	public static void main(String[] args){
		File fileRead;
		
		while(args.length == 0)
			args = inputToArgs();
		Debug.printf("%i arg found", args.length);
		String filename = args[0];
		if(filename.charAt(0) == '"' && filename.charAt(filename.length()-1) == '"')
			filename = filename.substring(1, filename.length()-1);
		
		fileRead = new File(filename);
		try{
			fileRead = fileRead.getCanonicalFile();
		} catch(java.io.IOException e) {
			fileRead = fileRead.getAbsoluteFile();
			e.printStackTrace();
		} catch(SecurityException e) {
			e.printStackTrace();
			return;
		}
		
		new DataParser(fileRead);
		
	}
	
	/**
	 * If no args were inputed, their values are taken from here
	 * @return the equivalent to main()'s args
	 */
	private static String[] inputToArgs(){
		Scanner in = new Scanner(System.in);
		ArrayList<String> args = new ArrayList<String>();
		
		System.out.println("Enter a filename or a filepath to read."); 
		
		while(in.hasNext()){
			args.add(in.next());
		}
		
		in.close();
		return args.toArray(new String[args.size()]);
	}
	
}
