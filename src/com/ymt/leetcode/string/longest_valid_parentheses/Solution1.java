package com.ymt.leetcode.string.longest_valid_parentheses;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description 参考题解
 * @author yumingtao
 * @date 2022-09-16 14:17
 */
public class Solution1 {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }

        return ans;
    }
}
