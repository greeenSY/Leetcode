package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
        int l=0,r=0;
        int max = 0;
        while(l!=len && r!=len){
        	Character tempChar = s.charAt(r);
        	while(!map.containsKey(tempChar) || map.get(tempChar) == 0){
        		map.put(tempChar, 1);
        		if(r++ ==len-1)
        			break;
        		tempChar = s.charAt(r);
        	}
        	if(r-l > max){
        		max = r-l;
        	}
        	map.put(s.charAt(l++), 0);
        }
		return max;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		String a = "abcabcbb";
		System.out.println(s.lengthOfLongestSubstring("c"));

	}

}
