package LengthofLastWord;

public class Solution {

	public static int lengthOfLastWord(String s) {
		int len = s.length();
		if(len == 0)
			return 0;
		int lastSpace = -1;
		while(len > 0){
			if(s.substring(0, len).endsWith(" "))
				len --;
			else
				break;
		}
		
		for(int i = 0; i < len; i++){
			if(s.substring(i).startsWith(" ")){
				lastSpace = i;
			}
				
		}
		
		return len - lastSpace - 1;
        
    }
	public static void main(String[] args) {
		String a = " 1 ";
		System.out.println(lengthOfLastWord(a));

	}

}
