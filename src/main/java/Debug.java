package main.java;

import java.util.Date;

public class Debug {

	public static boolean debugMode = true;
	
	public static <T> void println(T s){
		if(debugMode)
			System.err.println("[DEBUG] [" + new Date() + "] : " + s);
	}
	public static <T> void printf(T s, Object... args){
		if(debugMode)
			System.err.printf("[DEBUG] [" + new Date() + "] : " + s, args);
	}
	
}
