package com.ymt.leetcode.stack_queue.evaluate_reverse_polish_notation;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 使用栈
 * @author yumingtao
 * @date 2022-02-24 20:37
 */
public class Solution1 {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for (String s : tokens) {
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stack.push(s);
            } else {
                int num2 = Integer.valueOf(stack.pop());
                int num1 = Integer.valueOf(stack.pop());
                if (s.equals("+")) {
                    stack.push(String.valueOf(num1 + num2));
                }
                if (s.equals("-")) {
                    stack.push(String.valueOf(num1 - num2));
                }
                if (s.equals("*")) {
                    stack.push(String.valueOf(num1 * num2));
                }
                if (s.equals("/")) {
                    stack.push(String.valueOf(num1 / num2));
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
