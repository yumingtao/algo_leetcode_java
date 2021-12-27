package com.ymt.leetcode.two_pointers.get_equal_substrings_within_budget;

/**
 * 思路：滑窗+优化，会稍微快2ms
 *
 * @author yumingtao
 * @date 2021/12/27 15:32
 */
public class Solution2 {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int cost = 0;
        int maxLen = 0;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int right = 0; right < s.length(); right++) {
            cost += Math.abs(sArr[right] - tArr[right]);
            if(cost <= maxCost){
                maxLen = Math.max(maxLen, right - left + 1);
                continue;
            }

            while (cost > maxCost){
                cost -= Math.abs(sArr[left] - tArr[left]);
                ++left;
            }
        }
        return maxLen;
    }
}
