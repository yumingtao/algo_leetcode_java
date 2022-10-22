package com.ymt.leetcode.string.valid_palindrome_ii;

/**
 * @description 参考题解
 * @author yumingtao
 * @date 2022-10-22 13:41
 */
public class Solution1 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isvalid(s, left + 1, right) || isvalid(s, left, right - 1);
            } else {
                ++left;
                --right;
            }
        }
        return true;
    }

    private boolean isvalid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
