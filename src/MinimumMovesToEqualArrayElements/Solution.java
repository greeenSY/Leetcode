package MinimumMovesToEqualArrayElements;

public class Solution {
    public int minMoves(int[] nums) {
        int sum=0,min = nums[0];
        for(int i: nums){
            sum += i;
            if(i < min){
                min = i;
            }
        }
        return sum - min * (nums.length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bits = {1,2,3};
        System.out.println(solution.minMoves(bits));
    }

}
