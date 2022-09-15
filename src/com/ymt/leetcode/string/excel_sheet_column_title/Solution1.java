package com.ymt.leetcode.string.excel_sheet_column_title;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-15 15:20
 */
public class Solution1 {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            char ch = (char) ((columnNumber - 1) % 26 + 'A');
            ans.append(ch);
            columnNumber = (columnNumber - 1) / 26;
        }
        return ans.reverse().toString();
    }
}
