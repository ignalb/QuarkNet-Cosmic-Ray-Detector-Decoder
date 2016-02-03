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
	
	public void addData(DisplayST st){
		if(data.isEmpty()){
		} else {
			if(data.get(data.size()-1).hasST()){
			} else {
				int index = data.size()-1;
				Data d = data.get(index);
				d.setST(st);
				data.set(index, d);
				return;
			}
		}
		tTime += deltaT;
		data.add(new Data(tTime, st));
	}
	public void addData(DisplayDS ds){
		if(data.isEmpty()){
		} else {
			if(data.get(data.size()-1).hasDS()){
			} else {
				int index = data.size()-1;
				Data d = data.get(index);
				d.setDS(ds);
				data.set(index, d);
				return;
			}
		}
		tTime += deltaT;
		data.add(new Data(tTime, ds));
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
	public ArrayList<Data> getData(){
		return data;
	}
}

enum DataType {
	ST1, ST2, ST3
}