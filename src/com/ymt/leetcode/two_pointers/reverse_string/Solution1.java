package com.ymt.leetcode.two_pointers.reverse_string;

/**
 * @Description 双指针
 * @author yumingtao
 * @date 2022-02-03 16:40
 */
public class Solution1 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            ++left;
            --right;
        }
    }
}
