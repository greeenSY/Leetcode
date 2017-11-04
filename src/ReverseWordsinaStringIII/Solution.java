/**
 * @(#)Solution.java, 六月 29, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ReverseWordsinaStringIII;

/**
 * @author shenyang
 */
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        int lastPos = 0;
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == ' '){
                chars = reverseChar(chars, lastPos, i-1);
                lastPos = i+1;
            }
        }
        chars = reverseChar(chars, lastPos, chars.length-1);

        return new String(chars);
    }

    private char[] reverseChar(char[] chars, int start, int end){
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
        String st = "Let's take LeetCode contest";
        Solution s = new Solution();
        System.out.println(s.reverseWords(st));
    }
}