package ZigZagConversion;

public class Solution {

	public String convert(String s, int numRows) {
		if(s == null || s.isEmpty() || numRows < 1)
			return "";
		if(numRows == 1)
			return s;
		StringBuilder sb = new StringBuilder();
		int len = numRows*2-2;
		int num = s.length()/len+1;

		for(int i=0; i<numRows; i++){
			for(int j=0; j<num; j++){
				if(i+(j*len) >= s.length())
					break;
				sb.append(s.charAt(i+(j*len)));
				int sendline = len*(j+1) -i;
				if(i != 0 && i != numRows-1 && sendline < s.length()){
					sb.append(s.charAt(sendline));
				}
			}
		}
		return sb.toString();
    }
	public static void main(String[] args) {
		String a = "ABCD";
		Solution s = new Solution();
		System.out.println(s.convert(a, 3));

	}

}
