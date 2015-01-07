package SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution {

	 
	 public static List<Integer> findSubstring(String S, String[] L) {
		 int num = L.length;
		 int len = L[0].length();
		 List<Integer> result = new ArrayList<Integer>();
		 if(num == 0 || len == 0 || S.length() == 0)
			 return result;
		 
		 Map<String,Integer> wordcount = new HashMap<String,Integer>();
		 int i,j;
		 for (i = 0; i < num; i++) {
			 int wordNum = wordcount.containsKey(L[i]) ? wordcount.get(L[i]) : 0;
			 wordcount.put(L[i],wordNum+1);
		 }
		 Map<String,Integer> counting = new HashMap<String,Integer>();
		 
		 for(i = 0; i <= S.length() - len*num; i++){
			 counting.clear();
			 for(j = 0; j < num; j++){
				 String word = S.substring(i + j * len,i + j * len + len);
				 if(wordcount.containsKey(word)){
					 int wordNum = counting.containsKey(word) ? counting.get(word) : 0;
					 counting.put(word,wordNum+1);
					 
					 if(counting.get(word) > wordcount.get(word))
						 break;
				 }
				 else 
					 break;
			 }
			 if(j == num)
				 result.add(i);
		 }
		 
		 
		 return result;
	 }
	 public static void main(String[] args) {
		 String S = "barfoothefoobarman";
		 String[] L = {"foo", "bar"};
		 System.out.println(findSubstring(S,L));
		// TODO 自动生成的方法存根

	}

}
