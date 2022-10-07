package com.ymt.leetcode.string.repeated_substring_pattern;

/**
 * @description 题解实现
 * @author yumingtao
 * @date 2022-10-07 14:18
 */
public class Solution3 {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
