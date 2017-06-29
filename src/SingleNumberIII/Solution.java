/**
 * @(#)Solution.java, 六月 29, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package SingleNumberIII;

/**
 * @author shenyang
 */
public class Solution {
    public int[] singleNumber(int[] nums) {

        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        int[] testcase = {1, 2, 1, 3, 2, 5};

        Solution s = new Solution();
        int[] result = s.singleNumber(testcase);
        for(int i : result){
            System.out.println(i);
        }

        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(4));
    }
}