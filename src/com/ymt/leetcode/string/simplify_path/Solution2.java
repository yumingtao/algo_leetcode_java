package com.ymt.leetcode.string.simplify_path;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 参考题解
 * @author yumingtao
 * @date 2022-10-03 16:40
 */
public class Solution2 {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for (String s : arr) {
            if ("".equals(s) || ".".equals(s)) {
                continue;
            } else if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else {
                //stack.add(s);
                stack.offerLast(s);
            }
        }

        StringBuilder ans = new StringBuilder();
        if (stack.isEmpty()) {
            ans.append("/");
        } else {
            while (!stack.isEmpty()) {
                ans.append("/");
                ans.append(stack.pollFirst());
            }
        }

        return ans.toString();
    }
}
