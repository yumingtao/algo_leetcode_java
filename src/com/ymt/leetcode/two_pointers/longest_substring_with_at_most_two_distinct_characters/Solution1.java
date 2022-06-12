package com.ymt.leetcode.two_pointers.longest_substring_with_at_most_two_distinct_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 滑窗+Map
 * @author yumingtao
 * @date 2022-01-08 16:11
 */
public class Solution1 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        char[] sChArr = s.toCharArray();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); ++right) {
            countMap.put(sChArr[right], countMap.getOrDefault(sChArr[right], 0) + 1);
            if (countMap.size() <= 2) {
                maxLen = Math.max(maxLen, right - left + 1);
            } else if (countMap.size() > 2) {
                int leftChCount = countMap.get(sChArr[left]) - 1;
                if (leftChCount > 0) {
                    countMap.put(sChArr[left], leftChCount);
                } else {
                    countMap.remove(sChArr[left]);
                }
                ++left;
            }
        }
        return maxLen;
    }
}
