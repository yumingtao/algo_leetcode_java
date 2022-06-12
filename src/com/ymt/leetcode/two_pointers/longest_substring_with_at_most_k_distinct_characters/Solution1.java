package com.ymt.leetcode.two_pointers.longest_substring_with_at_most_k_distinct_characters;

/**
 * @Description 滑窗+计数
 * @author yumingtao
 * @date 2022-01-08 17:34
 */
public class Solution1 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] sChArr = s.toCharArray();
        int[] countsArr = new int[128];
        int slideCount = 0;
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); ++right) {
            ++countsArr[sChArr[right]];
            if (countsArr[sChArr[right]] == 1) {
                ++slideCount;
            }
            while (slideCount == k + 1) {
                --countsArr[sChArr[left]];
                if (countsArr[sChArr[left]] == 0) {
                    --slideCount;
                }
                ++left;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
