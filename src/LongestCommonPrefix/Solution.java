package LongestCommonPrefix;

public class Solution {
	
	public static String longestCommonPrefixOf2Str(String str1,String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		
		if(len1 == 0 || len2 == 0)
			return "";
		int len = len1 < len2 ? len1 : len2;
		for (int i = 0; i < len; i++){
			if(str1.charAt(i) != str2.charAt(i)){
				return str1.substring(0,i);
			}
		}
		return str1.substring(0,len);
	}
	public static String longestCommonPrefix(String[] strs) {
		String result = "";
		if(strs.length < 1)
			return result;
		result = strs[0];
		for(int i = 1; i < strs.length; i++){
			result = longestCommonPrefixOf2Str(result,strs[i]);
		}
		return result;
	        
	}
	 
	public static void main(String[] args) {
		String[] strs = {"asbcd","asb","assb"};
		String[] strs2 = {};
		System.out.print(longestCommonPrefix(strs));

	}
}
