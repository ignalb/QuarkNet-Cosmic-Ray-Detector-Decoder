package main.java;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static File file;		// filename to write to
	private static File fileRead;	// filename to read (if given)
	private static final String endSequence = "[EOF]";
	
	/**
	 * @param args <ul>
	 * 		<li><em>file_name.txt</em> in current path containing raw data</li> <ul><li>ex: data01261601.txt</li></ul>
	 * 		<li><em>file_path/file_name.txt</em> containing raw data</li> <ul><li>ex: C:\Users\<em>user</em>\Desktop\data01261601.txt</li></ul>
	 * 		<li>Direct raw data from zTerm or HyperText</li> <ul><li>__</li></ul> </ul>
	 * 			//TODO Check names of programs and fix if needed
	 * 			//TODO provide sample data
	 */
	public static void main(String[] args){
		
		if(args.length == 0)
			args = inputToArg();
		if(args.length == 1)	//File, either local or absolute
		{
			Debug.println("1 arg found");
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
			
		}
		else if(args.length > 1)
		{
			Debug.println(args.length + " args found");
			//TODO raw data
		}
		return;
		
	}
	
	/**
	 * If no args were inputed, their values are taken from here
	 * @return the equivalent to main()'s args
	 */
	private static String[] inputToArg(){
		Scanner in = new Scanner(System.in);
		String parser;
		ArrayList<String> args = new ArrayList<String>();
		
		System.out.printf("Enter a filename to read or the raw data.\n"
				+ "To finalize input enter the following character sequence: '%s'\n"
				+ "(Ctrl-z could achieve the same on a DOS system)\n", endSequence);
		
		while(true){
			parser = in.next();
			
			if(parser.equalsIgnoreCase(endSequence))
			{
				break;
			}
			else
			{
				args.add(parser);
			}
		}
		
		in.close();
		return args.toArray(new String[args.size()]);
	}
	
}
