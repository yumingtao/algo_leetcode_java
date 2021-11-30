package com.ymt.leetcode.two_pointers.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：
 *
 * @author yumingtao
 * @date 2021/11/30 09:21
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int right = 0; right < len; right++) {
            if (map.containsKey(s.charAt(right))) {
                //判断left和重复字符后边一个位置的大小，将left设置到较大的位置
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            maxLen = Math.max(maxLen, right - left + 1);
            //更新或添加right位置字符的索引位置
            map.put(s.charAt(right), right);
        }
        return maxLen;
    }
}
