package com.ymt.leetcode.string.di_string_match;

/**
 * @description
 * @author yumingtao
 * @date 2022-11-24 11:59
 */
public class Solution1 {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        int min = 0;
        int max = n;
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c == 'I') {
                ans[i] = min++;
            } else {
                ans[i] = max--;
            }
        }
        ans[n] = min;
        return ans;
    }
}
