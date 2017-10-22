/**
 * @(#)Solution.java, 七月 29, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package Game24;

/**
 * @author shenyang
 */
public class Solution {
    public boolean judgePoint24(int[] nums) {
        return f(new double[] {nums[0], nums[1], nums[2], nums[3]});
    }

    private boolean f(double[] a) {
        if (a.length == 1) {
            return Math.abs(a[0] - 24) < 0.001;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                double[] b = new double[a.length - 1];
                for (int k = 0, l = 0; k < a.length; k++) {
                    if (k != i && k != j) {
                        b[l++] = a[k];
                    }
                }
                for (double k : compute(a[i], a[j])) {
                    b[a.length - 2] = k;
                    if (f(b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private double[] compute(double a, double b) {
        return new double[] {a + b, a - b, b - a, a * b, a / b, b / a};
    }

    public static void main(String[] args) {
        int[] array = {4, 1, 8, 7};
        int[] array2 = {1, 2, 1, 2};

        Solution solution = new Solution();
        System.out.println(solution.judgePoint24(array));
        System.out.println(solution.judgePoint24(array2));
    }
}