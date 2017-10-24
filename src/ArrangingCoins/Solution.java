/**
 * @(#)Solution.java, 七月 29, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ArrangingCoins;

/**
 * @author shenyang
 */
public class Solution {
    public int arrangeCoins(int n) {
        int start = 0;
        int end = n;
        int mid = 0;
        while (start <= end){
            mid = (start + end) >>> 1;
            if ((0.5 * mid * mid + 0.5 * mid ) <= n){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrangeCoins(1));
        System.out.println(solution.arrangeCoins(5));
        System.out.println(solution.arrangeCoins(8));
    }
}