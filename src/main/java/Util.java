package main.java;

public class Util {

	public static String nextWord(String s){
		return (s.contains(" ")) ? s.substring(0, s.indexOf(" ")) : s;
	}
	
	
}
