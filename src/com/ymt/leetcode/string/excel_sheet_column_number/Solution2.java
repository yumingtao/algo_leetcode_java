package com.ymt.leetcode.string.excel_sheet_column_number;

/**
 * @description 题解
 * @author yumingtao
 * @date 2022-09-15 16:07
 */
public class Solution2 {
    public int titleToNumber(String columnTitle) {
        char[] titles = columnTitle.toCharArray();
        int len = titles.length;
        int multiple = 1;
        int ans = 0;
        for (int i = len - 1; i >= 0; --i) {
            int val = titles[i] - 'A' + 1;
            ans += val * multiple;
            multiple *= 26;
        }
        return ans;
    }
}
