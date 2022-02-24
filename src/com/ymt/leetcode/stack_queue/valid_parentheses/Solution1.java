package com.ymt.leetcode.stack_queue.valid_parentheses;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 使用栈
 * @author yumingtao
 * @date 2022-02-24 20:04
 */
public class Solution1 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch != ')' && ch != '}' && ch != ']') {
                stack.push(ch);
            } else {
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                if (ch == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
