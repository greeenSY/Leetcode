package WordPattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public boolean wordPattern2(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map index = new HashMap();
		for (Integer i=0; i<words.length; ++i)
			if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
				return false;
		return true;
	}

	public boolean wordPattern(String pattern, String str) {
		Map<Character, String> map = new HashMap<>();
		Map<String, Character> map2 = new HashMap<>();
		Map index = new HashMap();
		String[] words = str.split(" ");
		if(words.length != pattern.length()){
			return false;
		}
		for(int i=0; i<pattern.length(); i++){
			char c = pattern.charAt(i);
			if(map.containsKey(c)){
				if(!map.get(c).equals(words[i])){
					return false;
				}
			} else {
				map.put(c, words[i]);
			}
			if(map2.containsKey(words[i])){
				if(map2.get(words[i]) != c){
					return false;
				}
			} else {
				map2.put(words[i],c);
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
//		String pattern = "abba", str = "dog dog dog dog";
		String pattern = "aaaa", str = "dog dog dog dog";

		System.out.println(s.wordPattern(pattern, str));

	}

}
