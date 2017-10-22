/**
 * @(#)Solution.java, 七月 29, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ArithmeticSlices;

/**
 * @author shenyang
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {

        int num = A.length;
        int result = 0;
        for(int i = 0; i<num; i++){
            for(int j=3; i+j <= num; j++){
                if(isArithmeticSlices(A, i, j)){
                    result ++;
                }
            }
        }
        return result;
    }

    private boolean isArithmeticSlices(int[] A, int start, int length){
        if(length < 3){
            return false;
        }
        int slice = A[start+1] - A[start];
        for(int i = 2; i < length; i++){
            if(A[start + i] - A[start + i - 1] != slice){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};

        Solution solution = new Solution();
        System.out.println(solution.numberOfArithmeticSlices(array));
    }
}