package com.ymt.leetcode.string.excel_sheet_column_number;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-15 15:44
 */
public class Solution1 {
    public int titleToNumber(String columnTitle) {
        char[] titles = columnTitle.toCharArray();
        int len = titles.length;
        int ans = 0;
        for (int i = 0; i < len - 1; ++i) {
            int val = titles[i] - 'A' + 1;
            int count = len - 1 - i;
            while (count > 0) {
                val *= 26;
                count--;
            }
            ans += val;
        }
        ans += titles[len - 1] - 'A' + 1;
        return ans;
    }
}
