package main.java;

import java.util.ArrayList;

public class DataStorage {

	private ArrayList<DisplayST> st = new ArrayList<DisplayST>();
	private ArrayList<DisplayDS> ds = new ArrayList<DisplayDS>();
	private DataType type;
	private int deltaT;		//in minutes
	private long tTime = 0;	//elapsed time (in minutes)
	
	public DataStorage(DataType type, int dt){
		this.type = type;
		deltaT = dt;
	}
	
	public void addData(DisplayST st){
		addST(st);
	}
	public void addData(DisplayST st, DisplayDS ds){
		addST(st); addDS(ds);
	}
	private void addST(DisplayST st){
		this.st.add(st);
		tTime += deltaT;
	}
	private void addDS(DisplayDS ds){
		this.ds.add(ds);
	}
	
	public ArrayList<DisplayST> getSTs(){
		return st;
	}
	public ArrayList<DisplayDS> getDSs(){
		return ds;
	}
	public int getDeltaTime(){
		return deltaT;
	}
	public long getTime(){
		return tTime;
	}
	public DataType getSTtype(){
		return type;
	}
}

enum DataType {
	ST1, ST2, ST3
}