package com.ymt.leetcode.string.reverse_string;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-03 16:20
 */
public class Solution1 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            ++left;
            --right;
        }
    }
}
