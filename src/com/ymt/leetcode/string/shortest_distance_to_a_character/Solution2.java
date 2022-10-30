package com.ymt.leetcode.string.shortest_distance_to_a_character;

/**
 * @description 题解实现
 * @author yumingtao
 * @date 2022-10-30 16:38
 */
public class Solution2 {
    public int[] shortestToChar(String s, char c) {
        char[] sArr = s.toCharArray();
        int[] ans = new int[sArr.length];
        //从左往右遍历，计算与左侧最近c的距离
        int cIndex = -s.length();
        for (int i = 0; i < s.length(); ++i) {
            if (sArr[i] == c) {
                cIndex = i;
            }
            ans[i] = Math.abs(i - cIndex);
        }

        //从右往左遍历，计算与右侧最近c的距离
        cIndex = 2 * s.length();
        for (int i = s.length() - 1; i >= 0; --i) {
            if (sArr[i] == c) {
                cIndex = i;
            }
            ans[i] = Math.min(ans[i], Math.abs(i - cIndex));
        }
        return ans;
    }
}
