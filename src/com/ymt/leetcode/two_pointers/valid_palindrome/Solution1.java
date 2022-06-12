package com.ymt.leetcode.two_pointers.valid_palindrome;

/**
 * @Description 双指针对撞
 * @author yumingtao
 * @date 2022-01-25 21:32
 */
public class Solution1 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chs = s.toCharArray();
        while (left <= right) {
            if (!isValidNumberOrChar(chs[left])) {
                ++left;
                continue;
            }
            if (!isValidNumberOrChar(chs[right])) {
                --right;
                continue;
            }
            if (Character.toUpperCase(chs[left]) != Character.toUpperCase(chs[right])) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    private boolean isValidNumberOrChar(char ch) {
        int num = ch;
        if (num >= 48 && num <= 57) {
            return true;
        }
        if (num >= 65 && num <= 90) {
            return true;
        }
        if (num >= 97 && num <= 122) {
            return true;
        }
        return false;
    }
}
