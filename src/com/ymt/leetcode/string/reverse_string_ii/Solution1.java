package com.ymt.leetcode.string.reverse_string_ii;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-16 14:18
 */
public class Solution1 {
    public String reverseStr(String s, int k) {
        if (s.length() == 1) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            end = start + 2 * k;
            if (end > s.length()) {
                end = s.length();
            }
            StringBuilder sb = new StringBuilder();
            if (end - start < k) {
                sb.append(s.substring(start, end)).reverse();
            } else {
                sb.append(s.substring(start, start + k)).reverse().append(s.substring(start + k, end));
            }
            ans.append(sb);
            start = end;
        }

        return ans.toString();
    }
}
