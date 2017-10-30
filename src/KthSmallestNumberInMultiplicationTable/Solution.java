/**
 * @(#)Solution.java, 六月 29, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package KthSmallestNumberInMultiplicationTable;

/**
 * @author shenyang
 */


public class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1 , high = m * n + 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int c = count(mid, m, n);
            if (c >= k) high = mid;
            else low = mid + 1;
        }

        return high;
    }

    private int count(int v, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int temp = Math.min(v / i , n);
            count += temp;
        }
        return count;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.findKthNumber(3,3,5));
        System.out.println(s.findKthNumber(2,3,6));
    }
}