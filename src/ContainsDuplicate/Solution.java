package ContainsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int i : nums){
			if(set.contains(i)){
				return true;
			} else {
				set.add(i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] array = {1,2,3,1};
		System.out.println(s.containsDuplicate(array));

	}

}
