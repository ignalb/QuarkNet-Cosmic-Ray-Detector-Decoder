package main.java;

public class DisplayDS {
	
	private int[] chCount = new int[4];
	private int trigCount;
	
	public DisplayDS(int ch0, int ch1, int ch2, int ch3, int trig){
		int[] ch = { ch0, ch1, ch2, ch3 };
		for(int i = 0; i < chCount.length; i++){
			chCount[i] = ch[i];
		}
		trigCount = trig;
	}
	
	public static DisplayDS parseDS(String s){
		int[] ch = { 0, 0, 0, 0 };
		int trig = 0;
		
		while(s.substring(0, 3).equals("DS\n") || s.substring(0, 3).equals("DS ")){
			s = s.substring(2, s.length()).trim();
		}
		while(s.substring(0,  2).equals("DS")){
			s = s.substring(1, s.length()).trim();
		}
		
		for(int i = 0; i < 5; i++){
			String parser = Util.nextWord(s);
			s = s.substring(parser.length(), s.length()).trim();
			
			char[] leading = parser.substring(0, 3).toCharArray();
			if(leading[0] == 'C' && Character.isDigit(leading[1]) && leading[2] == '=')
				parser = parser.substring(3, parser.length());
			
			if(i < 4)
				ch[i] = Integer.parseInt(parser, 16);
			else
				trig = Integer.parseInt(parser, 16);
		}
		
		return new DisplayDS(ch[0], ch[1], ch[2], ch[3], trig);
	}
	
	public int[] getCounts(){
		return chCount;
	}
	public int getTrigCount(){
		return trigCount;
	}
}
