package com.ymt.leetcode.string.number_of_lines_to_write_string;

/**
 * @description 题解实现
 * @author yumingtao
 * @date 2022-10-29 17:19
 */
public class Solution2 {
    public int[] numberOfLines(int[] widths, String s) {
        int col = 1;
        int width = 0;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            width += widths[index];
            if (width > 100) {
                ++col;
                width = widths[index];
            }
        }
        return new int[]{col, width};
    }
}
