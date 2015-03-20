package ExcelSheetColumnNumber;

public class Solution {

	public static int titleToNumber(String s) {
		int n = s.length();
		int re = 0;
		for(int i = 0; i < n; i++){
			re *= 26;
			char c = s.charAt(i);
			re += (int)(c + 1 -'A');
		}
		return re;
        
    }
	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));

	}

}
