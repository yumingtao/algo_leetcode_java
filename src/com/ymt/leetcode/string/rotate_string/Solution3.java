package com.ymt.leetcode.string.rotate_string;

/**
 * @description 题解方法实现
 * @author yumingtao
 * @date 2022-10-29 14:58
 */
public class Solution3 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            boolean valid = true;
            for (int j = 0; j < len; ++j) {
                int mod = (i + j) % len;
                if (s.charAt(mod) != goal.charAt(j)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                return true;
            }
        }
        return false;
    }
}
