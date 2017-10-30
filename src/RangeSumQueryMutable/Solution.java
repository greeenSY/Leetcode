package RangeSumQueryMutable;

public class Solution {
    static class NumArray {
        int length = -1;
        int[] nums=null;
        int[] change=null;
        int[] sums=null;

        public NumArray(int[] nums) {
            if(nums == null || nums.length == 0){
                return;
            }
            this.length = nums.length;
            this.nums = new int[this.length];
            this.change = new int[this.length];
            this.sums = new int[this.length];
            this.nums[0] = nums[0];
            this.sums[0] = nums[0];
            this.change[0] = 0;
            for(int i = 1; i < this.length; i++) {
                this.change[i] = 0;
                this.nums[i] = nums[i];
                this.sums[i] = sums[i-1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if(this.length <= 0){
                return 0;
            }
            int sum = sums[j];
            if(i > 0)
                sum -= sums[i - 1];
            for(; i<=j; i++){
                sum += change[i];
            }
            return sum;
        }
        public void update(int i, int val) {
            this.change[i] = val - nums[i];
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0,2);
        System.out.println(param_1);
        obj.update(1,2);
        int param_2 = obj.sumRange(0,2);
        System.out.println(param_2);
    }

}
