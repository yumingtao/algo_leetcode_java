package com.ymt.leetcode.string.count_binary_substrings;

/**
 * @description 题解实现，solution2优化
 * @author yumingtao
 * @date 2022-10-22 15:04
 */
public class Solution3 {
    public int countBinarySubstrings(String s) {
        int len = s.length();
        int index = 0;
        int lastGroupCount = 0;
        int ans = 0;
        while (index < len) {
            char c = s.charAt(index);
            int count = 0;
            while (index < len && s.charAt(index) == c) {
                ++index;
                ++count;
            }
            ans += Math.min(lastGroupCount, count);
            lastGroupCount = count;
        }
        return ans;
    }
}
