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
		if(st == null){
			this.st = st;
		} else {
			System.err.println("Failed to set ST : ST is protected and already has a value.");
		}
	}
	public void setDS(DisplayDS ds){
		if(ds == null){
			this.ds = ds;
		} else {
			System.err.println("Failed to set DS : DS is protected and already has a value.");
		}
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
