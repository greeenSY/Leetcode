package ExcelSheetColumnTitle;

public class Solution {

	public static String convertToTitle(int n) {
		String re = "";
		while(n>0){
			n--;
			char c= (char)('A' + n%26);
			n/=26;
			re=c+re;
		}
		return re;
        
    }
	public static void main(String[] args) {
		System.out.println(convertToTitle(28));

	}

}
