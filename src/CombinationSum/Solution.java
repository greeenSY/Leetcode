package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solution {

	public static List<List<Integer>> CSum(int[] num, int start, int end, int target){
		if(start>=end || target < 0)
			return null;

		List<List<Integer>> sums = new ArrayList();
		if(target < num[start]){
			return null;
		} else if(target==num[start]){
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(num[start]);
			sums.add(tmp);
			return sums;
		}
		List<List<Integer>> sum1 = CSum(num,start+1,end,target-num[start]);
		List<List<Integer>> sum2 = CSum(num,start+1,end,target);
		if(sum1 != null){
			Iterator itr = sum1.iterator();
			while (itr.hasNext()) {
				List<Integer> nextObj = (List<Integer>) itr.next();
				nextObj.add(0,num[start]);
				sums.add(nextObj);
			}
		}
		if(sum2 != null){
			Iterator itr2 = sum2.iterator();
			while (itr2.hasNext()) {
				List<Integer> nextObj = (List<Integer>) itr2.next();
				sums.add(nextObj);
			}
		}
		return sums;
	}
	public static List removeDuplicateWithOrder(List list) {
		if(list == null)
			return null;
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        return newList;
    }
	public static List<List<Integer>> combinationSum2(int[] num, int target) {
		Arrays.sort(num);  
		int len = num.length;
		List<List<Integer>> result =  CSum(num,0,len,target);
		if(result == null)
			return new ArrayList();
		else
			return removeDuplicateWithOrder(result);
		
    }
	public static void main(String[] args) {
		int[] num = {10,1,2,7,6,1,5};
		int target = 8;
		int[] num1 = {2};
		int target1 = 1;
		System.out.print(combinationSum2(num1,target1));

	}

}
