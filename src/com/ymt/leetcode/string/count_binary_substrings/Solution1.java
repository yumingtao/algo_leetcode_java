package com.ymt.leetcode.string.count_binary_substrings;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 参考题解
 * @author yumingtao
 * @date 2022-10-22 14:54
 */
public class Solution1 {
    public int countBinarySubstrings(String s) {
        int len = s.length();
        List<Integer> counts = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < len; ++i) {
            if (i != 0 && s.charAt(i) != s.charAt(i - 1)) {
                counts.add(count);
                count = 1;
            } else {
                ++count;
            }
        }
        if (count != 0) {
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i - 1), counts.get(i));
        }
        return ans;
    }
}
