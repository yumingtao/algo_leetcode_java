package com.ymt.leetcode.string.remove_outermost_parentheses;

/**
 * @description
 * @author yumingtao
 * @date 2022-12-13 23:07
 */
public class Solution1 {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int start = 0;
        int end = 0;
        int count = 0;
        while (end < s.length()) {
            if (s.charAt(end) == '(') {
                ++count;
            } else {
                --count;
            }
            if (count == 0) {
                ans.append(s.substring(start + 1, end));
                start = end + 1;
            }
            ++end;
        }
        return ans.toString();
    }
}
