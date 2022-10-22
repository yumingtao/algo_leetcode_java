package com.ymt.leetcode.string.count_binary_substrings;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 题解实现
 * @author yumingtao
 * @date 2022-10-22 14:59
 */
public class Solution2 {
    public int countBinarySubstrings(String s) {
        int len = s.length();
        List<Integer> counts = new ArrayList<>();
        int index = 0;
        while (index < len) {
            char c = s.charAt(index);
            int count = 0;
            while (index < len && s.charAt(index) == c) {
                ++index;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i - 1), counts.get(i));
        }
        return ans;
    }
}
