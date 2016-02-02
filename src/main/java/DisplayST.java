package main.java;

public class DisplayST {

	private short mBar;
	private float GpsDegC;	//nnn => nn.n degC
	private short PPSdelay;
	private short cpuV;	//voltage in mVolts
	private String gpsUTC;	//UTC time
	private String gpsDate;
	private boolean isGpsValid;	//A=Valid, V=not
	private byte gpsNum;	//Number of Satellites
	private int PPStime;
	private float version;	//nnn => n.nn
	private short serial;	//serial number
	private String TMCregs;
	private String Cntlregs;
	
	public DisplayST(short mbar, float degC, short ppsDelay, short V, String utc, String date, boolean gpsValidity
			, byte GPSs, int ppsTime, float ver, short serNum, String tmc, String cntl)
	{
		mBar = mbar;		GpsDegC = degC;	PPSdelay = ppsDelay;
		cpuV = V;			gpsUTC = utc;	gpsDate = date;
		isGpsValid = gpsValidity;			gpsNum = GPSs;
		PPStime = ppsTime;	version = ver;	serial = serNum;
		TMCregs = tmc;		Cntlregs = cntl;
	}
	
	public static DisplayST parseST(String s){
		short mbar = 0;	float degC = 0;	short ppsDelay = 0;	short V = 0;	String utc = "";	String date = "";	boolean gpsValid = false;
		byte GPSs = 0;	int ppsTime = 0;	float ver = 0.0f;	short serNum = 0;	String tmc = "";	String cntl = "";
		while(s.substring(0, 3).equals("ST\n") || s.substring(0, 3).equals("ST ")){
			s = s.substring(2, s.length()).trim();
		}
		while(s.substring(0,  2).equals("ST")){
			s = s.substring(1, s.length()).trim();
		}
		//Debug.println(s);
		
		for(int i = 1; i <= 13; i++){
			String parser = Util.nextWord(s);
			s = s.substring(parser.length(), s.length()).trim();
			
			switch(i){
				case 1:
					mbar = Short.parseShort(parser);
					break;
				case 2:
					degC = Float.parseFloat(parser) / 10;
					break;
				case 3:
					ppsDelay = Short.parseShort(parser);
					break;
				case 4:
					V = Short.parseShort(parser);
					break;
				case 5:
					utc = parser;
					break;
				case 6:
					date = parser;
					break;
				case 7:
					gpsValid = (parser.equals("A")) ? true : false;
					break;
				case 8:
					GPSs = Byte.parseByte(parser);
					break;
				case 9:
					ppsTime = Integer.parseInt(parser, 16);
					break;
				case 10:
					ver = Float.parseFloat(parser) / 100;
					break;
				case 11:
					serNum = Short.parseShort(parser);
					break;
				case 12:
					tmc = parser;
					break;
				case 13:
					cntl = parser;
					break;
				default:
					System.err.println("Invalid ST: " + parser);
			}
		}
		
		return new DisplayST(mbar, degC, ppsDelay, V, utc, date, gpsValid, GPSs, ppsTime, ver, serNum, tmc, cntl);
	}

	public short getMbar(){   return mBar;   }
	public float getGpsDegC(){   return GpsDegC;   }
	public short getPPSdelay(){   return PPSdelay;   }
	public short getCpuV(){   return cpuV;   }
	public String getGpsUTC(){   return gpsUTC;   }
	public String getGpsDate(){   return gpsDate;   }
	public boolean isGpsValid(){   return isGpsValid;   }
	public byte getGpsNum(){   return gpsNum;   }
	public int getPPStime(){   return PPStime;   }
	public float getVersion(){   return version;   }
	public short getSerial(){   return serial;   }
	public String getTmcRegs(){   return TMCregs;   }
	public String getCntlRegs(){   return Cntlregs;   }
}
