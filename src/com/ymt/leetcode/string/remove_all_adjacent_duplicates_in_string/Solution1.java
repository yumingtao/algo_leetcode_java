package com.ymt.leetcode.string.remove_all_adjacent_duplicates_in_string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description
 * @author yumingtao
 * @date 2022-12-18 16:41
 */
public class Solution1 {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
