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
public class Solution2 {
    private int result;
    public int numberOfArithmeticSlices(int[] A) {

        int num = A.length;
        for(int i = 0; i<num; i++){
            i += isArithmeticSlices(A, i);
        }
        return this.result;
    }

    private int isArithmeticSlices(int[] A, int start){
        if(start + 1 >= A.length){
            return 0;
        }
        int slice = A[start+1] - A[start];
        int length = 2;
        for(; length+start < A.length; length++){
            if(A[start + length] - A[start + length - 1] != slice){
                break;
            }
        }
        if(length < 3){
            return 0;
        } else {
            this.result += getTotalNum(length);
            return length - 1;
        }
    }

    private int getTotalNum(int l){
        if(l < 3){
            return 0;
        }
        return (l-1) * (l-2) / 2;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        Solution2 solution = new Solution2();
        System.out.println(solution.numberOfArithmeticSlices(array));
    }
}