package WildcardMatching;

public class Solution {

	public static boolean isMatch(String s, String p) {
		if (s == null || p == null) return false;
		if (s.equals(p)) return true;
		int lenS = s.length();
		int lenP = p.length();
		int i = 0,j = 0;
		int starPos = -1,SbackPos = -1;
		while(i<lenS){
			if(j<lenP && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))){
				i++;
				j++;
			} else if(j<lenP && p.charAt(j) == '*'){
				SbackPos = i;
				while(j<lenP && p.charAt(j) == '*')
					j++;
				starPos = j;
				continue;
			} else if (starPos != -1){
				//not match, back to startPos and SbackPos
				i = SbackPos;
				j = starPos;
				SbackPos++;
			} else
				return false;
			
		}
		while(j < lenP && p.charAt(j) == '*')
			j++;
		return i == lenS && j == lenP;
        
    }
	public static void main(String[] args) {
		String a = "acsdcdfsb";
		String b = "a*c*b";
		System.out.println(isMatch(a,b));

	}

}
