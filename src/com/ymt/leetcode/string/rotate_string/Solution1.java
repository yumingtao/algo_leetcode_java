package com.ymt.leetcode.string.rotate_string;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-29 14:38
 */
public class Solution1 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }
}
