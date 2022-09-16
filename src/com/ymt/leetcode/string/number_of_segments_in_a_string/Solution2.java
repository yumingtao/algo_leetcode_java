package com.ymt.leetcode.string.number_of_segments_in_a_string;

/**
 * @description 参考题解
 * @author yumingtao
 * @date 2022-09-16 12:09
 */
public class Solution2 {
    public int countSegments(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                ++ans;
            }
        }
        return ans;
    }
}
