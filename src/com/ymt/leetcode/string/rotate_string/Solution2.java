package com.ymt.leetcode.string.rotate_string;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-29 14:48
 */
public class Solution2 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        StringBuilder sb = new StringBuilder(s);
        int sLen = s.length();
        int lastIndex = sLen - 1;
        for (int i = 0; i < sLen; ++i) {
            char last = sb.charAt(lastIndex);
            sb.deleteCharAt(lastIndex);
            sb.insert(0, last);
            if (sb.toString().equals(goal)) {
                return true;
            }
        }
        return false;
    }
}
