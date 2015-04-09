package RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Solution {
	    public static List<String> findRepeatedDnaSequences(String s) {
	        List<String> result = new ArrayList<String>();
	        if(s == null || s.length() < 10) return result;
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        Integer val = 0;
	        for(int i = 0; i < 10; i ++){
	            val = val << 2;
	            val |= toInt(s.charAt(i));
	        }
	        map.put(val, 1);
	        for(int i = 10; i < s.length(); i ++){
	            val = ((val & 0x3ffff) << 2) | toInt(s.charAt(i));
	            if(map.containsKey(val)) map.put(val, map.get(val) + 1);
	            else map.put(val, 1);
	        }
	        for(Integer v : map.keySet())
	            if(map.get(v) > 1) result.add(toDNA(v));
	        return result;
	    }
	    
	    private static Integer toInt(char c){
	        if(c == 'A') return 0;
	        else if(c == 'C') return 1;
	        else if(c== 'G') return 2;
	        else return 3;//T
	    }
	    
	    private static String toDNA(Integer i){
	        StringBuilder sb = new StringBuilder();
	        for(int j = 0; j < 10; j ++){
	            int tmp = i % 4;
	            i = i / 4;
	            char c = 'T';
	            if(tmp == 0) c = 'A';
	            else if(tmp == 1) c = 'C';
	            else if(tmp == 2) c ='G';
	            sb.insert(0, c);
	        }
	        return sb.toString();
	    }
	public static void main(String[] args) {
		String dna = "AAAAAAAAAAAAAA";
		System.out.println(findRepeatedDnaSequences(dna));

	}

}
