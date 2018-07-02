/**
 * @(#)Solution.java, 六月 29, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ReverseStringII;

/**
 * @author shenyang
 */

class Solution {

    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k == 1) return s;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i+=2*k){
            chars = reverseChar(chars, i, i+k-1);
        }

        return new String(chars);
    }

    private char[] reverseChar(char[] chars, int start, int end){
        if(end >= chars.length){
            end = chars.length -1;
        }
        while(start<end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return chars;
    }

    public static void main(String[] args) {
        String st = "abcdefg";
        Solution s = new Solution();
        System.out.println(s.reverseStr(st,2));
    }
}