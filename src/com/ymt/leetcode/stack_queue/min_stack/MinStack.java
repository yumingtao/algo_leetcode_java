package com.ymt.leetcode.stack_queue.min_stack;

import java.util.Stack;

/**
 * @Description
 * @author yumingtao
 * @date 2022-02-22 20:00
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        int min = minStack.isEmpty() ? val : Math.min(minStack.peek(), val);
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
