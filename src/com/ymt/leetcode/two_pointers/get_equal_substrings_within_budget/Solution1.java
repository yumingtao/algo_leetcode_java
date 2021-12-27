package com.ymt.leetcode.two_pointers.get_equal_substrings_within_budget;

/**
 * 思路：采用滑动窗口
 *
 * @author yumingtao
 * @date 2021/12/27 10:26
 */
public class Solution1 {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int cost = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            cost += Math.abs(s.charAt(right) - t.charAt(right));
            if(cost <= maxCost){
                maxLen = Math.max(maxLen, right - left + 1);
                continue;
            }

            while (cost > maxCost){
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                ++left;
            }
        }
        return maxLen;
    }
}
