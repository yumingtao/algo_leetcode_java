package com.ymt.leetcode.string.remove_palindromic_subsequences;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-03 20:17
 */
public class Solution1 {
    public int removePalindromeSub(String s) {
        //先判断字符串本身是不是回文
        int left = 0;
        int right = s.length();
        while (left < right) {
            if (s.charAt(left++) != s.charAt(--right)) {
                //不是回文直接返回2，一次全消除a，一次全消除b
                return 2;
            }
        }
        //是回文，直接一次全消除
        return 1;
    }
}
