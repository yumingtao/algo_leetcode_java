package com.ymt.leetcode.two_pointers.longest_substring_with_at_most_two_distinct_characters;

/**
 * @Description 参考题解
 * @author yumingtao
 * @date 2022-01-08 16:56
 */
public class Solution2 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] sChArr = s.toCharArray();
        int[] countsArr = new int[128];
        int slideCount = 0;
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); ++right) {
            ++countsArr[sChArr[right]];
            if(countsArr[sChArr[right]] == 1){
                ++slideCount;
            }
            while (slideCount == 3){
                --countsArr[sChArr[left]];
                if(countsArr[sChArr[left]] == 0){
                    --slideCount;
                }
                ++left;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
    }
}
