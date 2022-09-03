package com.ymt.leetcode.string.count_substrings_with_only_one_distinct_letter;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-03 18:29
 */
public class Solution1 {
    public int countLetters(String s) {
        char[] chs = s.toCharArray();
        int start = 0;
        int end = 0;
        int ans = 0;
        while (start < chs.length) {
            while (end < chs.length) {
                if (chs[start] != chs[end]) {
                    break;
                }
                ++ans;
                ++end;
            }
            ++start;
            end = start;
        }
        return ans;
    }
}
