package com.ymt.leetcode.string.backspace_string_compare;

/**
 * @description
 * @author yumingtao
 * @date 2022-11-05 17:56
 */
public class Solution1 {
    public boolean backspaceCompare(String s, String t) {
        return getFinalString(s).equals(getFinalString(t));
    }

    private String getFinalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c != '#') {
                sb.append(c);
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
