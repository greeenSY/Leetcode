package TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer,Integer> numMap = new HashMap<Integer,Integer>();
		for(int i=0; i<nums.length; i++){
			if(numMap.containsKey(nums[i])){
				result[0] = numMap.get(nums[i])+1;
				result[1] = i+1;
				break;
			}
			int key = target - nums[i];
			if(!numMap.containsKey(key)){
				numMap.put(key, i);
			}
		}
		return result;
        
    }
	public static void main(String[] args) {
		int[] testCase = {0,4,3,0};
		int target = 0;
		int[] re = twoSum(testCase,target);
		for(int i:re){
			System.out.println(i);
		}
		

	}

}
