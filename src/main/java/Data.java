package main.java;

public class Data {

	private DisplayST st;
	private DisplayDS ds;
	private long time;
	
	public Data(long t, DisplayST st){
		this(t, st, null);
	}
	public Data(long t, DisplayST st, DisplayDS ds){
		this.st = st;
		this.ds = ds;
		time = t;
	}
	
	public DisplayST getST(){
		return st;
	}
	public DisplayDS getDS(){
		return ds;
	}
	public long getTime(){
		return time;
	}
	
}
