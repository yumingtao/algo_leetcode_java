package com.ymt.leetcode.map_set.longest_substring_without_repeating_characters;

import java.util.HashMap;

/**
 * @Description 使用滑窗HashMap
 * @author yumingtao
 * @date 2022/3/7 10:17
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();
        HashMap<Character, Integer> slideMap = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); ++right) {
            if (slideMap.containsKey(chs[right])) {
                left = Math.max(left, slideMap.get(chs[right]) + 1);
            }
            slideMap.put(chs[right], right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
