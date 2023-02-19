package com.ymt.leetcode.two_pointers.backspace_string_compare;

/**
 * 思路：直接使用StringBuilder
 *
 * @author yumingtao
 * @date 2022/2/7 14:49
 */
public class Solution2 {
    public boolean backspaceCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }

    private String getString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch == '#') {
                if(sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
