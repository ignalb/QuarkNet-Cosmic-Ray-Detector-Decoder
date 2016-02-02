package main.java;

import java.util.ArrayList;

public class DataStorage {

	private ArrayList<Data> data = new ArrayList<Data>();
	private DataType type;
	private int deltaT;		//in minutes
	private long tTime = 0;	//elapsed time (in minutes)
	
	public DataStorage(DataType type, int dt){
		this.type = type;
		deltaT = dt;
	}
	
	protected void addData(Data d){
		data.add(d);
	}
	public void addData(DisplayST st){
		addData(st, null);
	}
	public void addData(DisplayST st, DisplayDS ds){
		tTime += deltaT;
		addData(new Data(tTime, st, ds));
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