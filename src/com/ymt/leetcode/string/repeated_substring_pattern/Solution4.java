package com.ymt.leetcode.string.repeated_substring_pattern;

/**
 * @description 题解实现
 * @author yumingtao
 * @date 2022-10-07 14:33
 */
public class Solution4 {
    public boolean repeatedSubstringPattern(String s) {
        int sLen = s.length();
        for (int subLen = 1; subLen <= sLen / 2; ++subLen) {
            if (sLen % subLen != 0) {
                continue;
            }
            boolean match = true;
            for (int j = subLen; j < sLen; ++j) {
                if (s.charAt(j) != s.charAt(j - subLen)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }

        return false;
    }
}
