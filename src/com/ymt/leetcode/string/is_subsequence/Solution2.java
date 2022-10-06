package com.ymt.leetcode.string.is_subsequence;

/**
 * @description 题解实现
 * @author yumingtao
 * @date 2022-10-06 13:21
 */
public class Solution2 {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int i = 0;
        int j = 0;
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                ++i;
            }
            ++j;
        }
        return i == sLen;
    }
}
