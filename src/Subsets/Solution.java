package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		List<List<Integer>> tmp = new ArrayList<List<Integer>>();
		re.add(new ArrayList<Integer>());
		int n = S.length;
		if(n == 0)
			return re;
		Arrays.sort(S);
		for(int i = 0; i < n; i++){
			tmp.addAll(re);
			for(List<Integer> l : tmp){
				List<Integer> t = new ArrayList<Integer>();
				t.addAll(l);
				t.add(S[i]);
				re.add(t);
			}
			tmp.clear();
		}
		return re;
    }
	public static void main(String[] args) {
		int[] S = {3,1,2};
		for (int i : S) {
			System.out.print(i);
			System.out.print(",");
		}
		System.out.println();
		
		System.out.println(subsets(S));

	}

}
