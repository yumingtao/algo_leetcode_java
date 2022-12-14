package com.ymt.leetcode.string.remove_outermost_parentheses;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description 题解使用栈
 * @author yumingtao
 * @date 2022-12-14 21:19
 */
public class Solution3 {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans.append(c);
            }
            if (c == '(') {
                stack.push(c);
            }
        }

        return ans.toString();
    }
}
