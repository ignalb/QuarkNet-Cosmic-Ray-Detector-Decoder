package main.java;

public class Data {

	private DisplayST st;
	private DisplayDS ds;
	private long time;
	
	public Data(long t, DisplayST st){
		this(t, st, null);
	}
	public Data(long t, DisplayDS ds){
		this(t, null, ds);
	}
	public Data(long t, DisplayST st, DisplayDS ds){
		this.st = st;
		this.ds = ds;
		time = t;
	}
	
	public void setST(DisplayST st){
		this.st = st;
	}
	public void setDS(DisplayDS ds){
		this.ds = ds;
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
	
	public boolean hasST(){
		return (st == null) ? false : true;
	}
	public boolean hasDS(){
		return (ds == null) ? false : true;
	}
	
}
