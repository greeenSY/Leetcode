package LongestCommonPrefix;
/*
 * I made a mistake here. this is a solution of the longest common subsequence but the longest common prefix
 */
public class Solution_CommonSubsequence {
	
	public static String longestCommonPrefixOf2Str(String str1,String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		if(len1 == 0 || len2 == 0)
			return "";
		if(str1.charAt(len1-1) == str2.charAt(len2-1))
			return longestCommonPrefixOf2Str(str1.substring(0,len1-1),str2.substring(0,len2-1))+str1.charAt(len1-1);
		else {
			String re1 = longestCommonPrefixOf2Str(str1.substring(0,len1),str2.substring(0,len2-1));
			String re2 = longestCommonPrefixOf2Str(str1.substring(0,len1-1),str2.substring(0,len2));
			return re1.length() >= re2.length() ? re1 : re2;
		}
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
		String[] strs = {"abcd","asb","assb"};
		String[] strs2 = {};
		System.out.print(longestCommonPrefix(strs2));

	}
}
