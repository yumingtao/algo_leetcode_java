package com.ymt.leetcode.string.number_of_lines_to_write_string;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-29 17:13
 */
public class Solution1 {
    public int[] numberOfLines(int[] widths, String s) {
        int[] ans = new int[2];
        int col = 0;
        int width = 0;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            width += widths[index];
            if (width >= 100) {
                ++col;
                width = width == 100 ? 0 : widths[index];
            }
        }
        if (width != 0) {
            ++col;
        } else {
            width = 100;
        }
        ans[0] = col;
        ans[1] = width;
        return ans;
    }
}
