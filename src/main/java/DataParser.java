package main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataParser {

	private static final String EXT = "csv";
	private ArrayList<DataStorage> dataCollections = new ArrayList<DataStorage>();
	
	public DataParser(File read){
		File writeF;
		FileWriter writer;
		Scanner reader;
		
		try {
			String filename = read.getPath().substring(0, read.getPath().lastIndexOf('.')) + "." + EXT;
			Debug.println("Writer filename = " + filename);
			writeF = new File(filename);
			reader = new Scanner(read);
			writer = new FileWriter(writeF);
			
			while(reader.hasNext()){
				String parser = reader.nextLine();
				parse(parser);
				
				try{	//TODO debug. is temp
					ArrayList<Data> ds = dataCollections.get(0).getData();
					Data d = ds.get(ds.size()-1);
					Debug.printf("%2d: hasST=%b hasDS=%b\n", ds.size(), d.hasST(), d.hasDS());
				}catch(Exception e){}
			}
			
			write(writer, DataRequest.COUNTS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void parse(String parser) {
		if(parser.equals("ST 0") || parser.matches("ST [1-3] (\\d){1,}")){
		// ST writer parser
			int type = Integer.parseInt(Character.toString(parser.charAt(3)));
			if(type >=1 && type <= 3){
				int dt = Integer.parseInt(parser.substring(5, parser.length()));
				DataStorage data = null;
				switch(type){
					case 1:
						data = new DataStorage(DataType.ST1, dt);
						break;
					case 2:
						data = new DataStorage(DataType.ST2, dt);
						break;
					case 3:
						data = new DataStorage(DataType.ST3, dt);
						break;
				}
				dataCollections.add(data);
			}
		}else if(parser.matches("DS( [\\d|A-F|a-f]{8}){5}") || parser.matches("DS( C\\d=[\\d|A-F|a-f]{8}){5}")){
		// DS reader parser
			//TODO remove second version as it is intended to show the user not collect data
			if(dataCollections.size() > 0){
				dataCollections.get(dataCollections.size()-1).addData(DisplayDS.parseDS(parser));
			}
		} else if(parser.matches("ST \\d{4}( [+|-]\\d{3}){2} \\d{4}( \\d{6}){2} [A|V] \\d{2} [\\d|A-F|a-f]{8} \\d{3} \\d{4}( [\\d|A-F|a-f]{8}){2}")){
		// ST reader parser
			if(dataCollections.size() > 0){
				dataCollections.get(dataCollections.size()-1).addData(DisplayST.parseST(parser));
			}
		}
	}
	
	private void write(FileWriter f, DataRequest requestType){
		for(DataStorage datas : dataCollections){
			try {
				f.append("Time,Ch0,Ch1,Ch2,Ch3\n");
				switch(requestType){
					case COUNTS:
						for(Data d : datas.getData()){
							int[] ch = d.getDS().getCounts();
							f.append(d.getTime() + "," + ch[0] + "," + ch[1] + "," + ch[2] + "," + ch[3] + "\n");
						}
						break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			f.flush();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Receives a file's time metadata and returns the date as a String
	 * @param t Time Stamp
	 * @return Date as a String
	 */
	public static String timeToStringDate(java.nio.file.attribute.FileTime t){
		return timeToStringDate(t.toString());
	}
	
	public static String timeToStringDate(String time){
		return time.substring(0, 10);
	}
}

enum DataRequest {
	COUNTS
}