package com.ymt.leetcode.two_pointers.backspace_string_compare;

import java.util.Stack;

/**
 * 思路：使用栈
 *
 * @author yumingtao
 * @date 2022/2/7 11:26
 */
public class Solution1 {
    public boolean backspaceCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }

    private String getString(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch == '#') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
