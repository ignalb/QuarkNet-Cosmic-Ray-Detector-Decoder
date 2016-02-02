package main.java;

public class DisplayDS {
	
	private int[] chCount = new int[4];
	private int trigCount;
	
	public DisplayDS(String ch0_16, String ch1_16, String ch2_16, String ch3_16, String trig_16){
		String[] chHex = { ch0_16, ch1_16, ch2_16, ch3_16 };
		for(int i = 0; i < chCount.length; i++){
			chCount[i] = Integer.parseInt(chHex[i], 16);
		}
		trigCount = Integer.parseInt(trig_16, 16);
	}
	public DisplayDS(int ch0, int ch1, int ch2, int ch3, int trig){
		int[] ch = { ch0, ch1, ch2, ch3 };
		for(int i = 0; i < chCount.length; i++){
			chCount[i] = ch[i];
		}
		trigCount = trig;
	}
	
	public int[] getCounts(){
		return chCount;
	}
	public int getTrigCount(){
		return trigCount;
	}
}
