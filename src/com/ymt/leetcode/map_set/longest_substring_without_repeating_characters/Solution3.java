package com.ymt.leetcode.map_set.longest_substring_without_repeating_characters;

import java.util.HashMap;

/**
 * @Description 使用滑窗和HashMap
 * @author yumingtao
 * @date 2022/3/7 10:40
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();
        HashMap<Character, Integer> slideMap = new HashMap<>();
        int right = 0;
        int maxLen = 0;
        for (int left = 0; left < s.length(); ++left) {
            while (right < s.length() && !slideMap.containsKey(chs[right])) {
                slideMap.put(chs[right], right);
                ++right;
            }
            maxLen = Math.max(maxLen, right - left);
            slideMap.remove(chs[left]);
        }
        return maxLen;
    }
}
