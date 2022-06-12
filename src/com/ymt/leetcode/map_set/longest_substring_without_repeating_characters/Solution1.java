package com.ymt.leetcode.map_set.longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 维护滑动窗口内的Map
 * @author yumingtao
 * @date 2022/3/7 08:53
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();
        Set<Character> slideSet = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            if (slideSet.contains(chs[right])) {
                //移除滑出窗口的字符
                while (left < right && chs[left] != chs[right]) {
                    slideSet.remove(chs[left++]);
                }
                //如果left<right但字符相同，将left移动到下一个位置
                if (left != right) {
                    ++left;
                }
            } else {
                slideSet.add(chs[right]);
            }
            maxLen = Math.max(maxLen, right - left + 1);
            ++right;
        }
        return maxLen;
    }
}
