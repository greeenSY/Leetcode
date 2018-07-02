package PowerOfThree;

public class Solution {

    public boolean isPowerOfThree(int n) {
        return n>0 && (n==1 || (n%3==0 && isPowerOfThree(n/3)));
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfThree(3));
        System.out.println(s.isPowerOfThree(9));
        System.out.println(s.isPowerOfThree(729));
        System.out.println(s.isPowerOfThree(18));
    }

}
