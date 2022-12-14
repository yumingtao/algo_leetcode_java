package com.ymt.leetcode.string.remove_outermost_parentheses;

/**
 * @description 题解计数
 * @author yumingtao
 * @date 2022-12-14 21:11
 */
public class Solution2 {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                --count;
            }
            if (count > 0) {
                ans.append(c);
            }
            if (c == '(') {
                ++count;
            }
        }

        return ans.toString();
    }
}
