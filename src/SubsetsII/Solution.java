package SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static List<List<Integer>> subsetsWithDup2(int[] num) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		List<List<Integer>> tmp = new ArrayList<List<Integer>>();
		re.add(new ArrayList<Integer>());
		int n = num.length;
		if(n == 0)
			return re;
		
		Arrays.sort(num);
		for(int i = 0; i < n; i++){
			tmp.addAll(re);
			for(List<Integer> l : tmp){
				List<Integer> t = new ArrayList<Integer>();
				t.addAll(l);
				t.add(num[i]);
				if(re.contains(t))
					continue;
				re.add(t);
			}
			tmp.clear();

		}
		return re;
        
    }
	
	public static List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		List<List<Integer>> tmp = new ArrayList<List<Integer>>();
		int lastSize = 0;
		re.add(new ArrayList<Integer>());
		int n = num.length;
		if(n == 0)
			return re;
		
		Arrays.sort(num);
		for(int i = 0; i < n; i++){
			if(i>0 && num[i]==num[i-1]){
				tmp.addAll(re);
				int m = re.size();
				for(int j=lastSize;j<m;j++){
					List<Integer> l = re.get(j);
			
					List<Integer> t = new ArrayList<Integer>();
					t.addAll(l);
					t.add(num[i]);
					re.add(t);
				}
				lastSize = tmp.size();
				tmp.clear();
			} else {
				tmp.addAll(re);
				for(List<Integer> l : tmp){
					List<Integer> t = new ArrayList<Integer>();
					t.addAll(l);
					t.add(num[i]);
					re.add(t);
				}
				lastSize = tmp.size();
				tmp.clear();
			}
		}
		return re;
        
    }
	public static void main(String[] args) {
		int[] S = {2,2,2};
		for (int i : S) {
			System.out.print(i);
			System.out.print(",");
		}
		System.out.println();
		
		System.out.println(subsetsWithDup(S));

	}

}
