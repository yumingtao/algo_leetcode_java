package com.ymt.leetcode.two_pointers.valid_palindrome;

/**
 * 思路：双指针对撞
 *
 * @author yumingtao
 * @date 2022/1/26 16:15
 */
public class Solution2 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chs = s.toCharArray();
        while (left <= right) {
            if (!Character.isLetterOrDigit(chs[left])) {
                ++left;
                continue;
            }
            if (!Character.isLetterOrDigit(chs[right])) {
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
}
