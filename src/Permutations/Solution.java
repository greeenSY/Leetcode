package Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        return getPermute(nums, 0, nums.length);
    }

    public List<List<Integer>> getPermute(int[] nums, int start, int length) {
        List<List<Integer>> result = new ArrayList<>();

        if(length > 1){
            List<List<Integer>> resultChild = getPermute(nums, start+1, length-1);
            for(List<Integer> p : resultChild){
                for(int i=0; i <= p.size(); i++){
                    List<Integer> newP = new ArrayList<>(p);
                    newP.add(i, nums[start]);
                    result.add(newP);
                }
            }
            return result;
        } else if(length == 1){
            List<Integer> newArray = new ArrayList<>();
            newArray.add(nums[start]);
            result.add(newArray);
            return result;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
//        int[] M = {4,3,2,7,8,1};
        int[] M = {1,2,3};
        Solution s = new Solution();
        System.out.println(s.permute(M));
    }

}
