package com.ymt.leetcode.string.number_of_segments_in_a_string;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-16 12:06
 */
public class Solution1 {
    public int countSegments(String s) {
        int ans = 0;
        boolean lastIsBlank = true;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                if (!lastIsBlank) {
                    ++ans;
                    lastIsBlank = true;
                }
            } else {
                if (lastIsBlank) {
                    lastIsBlank = false;
                }
            }
            ++i;
        }

        if (!lastIsBlank) {
            ++ans;
        }
        return ans;
    }
}
