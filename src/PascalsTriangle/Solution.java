package PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(numRows <= 0)
			return result;
		List<Integer> tmp = new ArrayList<Integer>();
		tmp.add(1);
		result.add(tmp);
		
		for(int i = 1; i < numRows; i++){
			tmp = new ArrayList<Integer>();
			tmp.add(1);
			for(int j = 1; j < i ; j++){
				tmp.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
				
			}
			tmp.add(1);
			result.add(tmp);
			
		}
		return result;
        
    }
	public static void main(String[] args) {
		System.out.println(generate(5));
	}

}
