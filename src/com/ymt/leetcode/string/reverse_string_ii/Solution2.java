package com.ymt.leetcode.string.reverse_string_ii;

/**
 * @description 题解实现
 * @author yumingtao
 * @date 2022-10-16 14:29
 */
public class Solution2 {
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] chs = s.toCharArray();
        for (int i = 0; i < len; i += 2 * k) {
            reverseCharArray(chs, i, Math.min(i + k, len) - 1);
        }
        return new String(chs);
    }

    private void reverseCharArray(char[] chs, int start, int end) {
        while (start < end) {
            char tmp = chs[start];
            chs[start] = chs[end];
            chs[end] = tmp;
            ++start;
            --end;
        }
    }
}
