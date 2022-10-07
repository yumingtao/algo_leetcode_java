package com.ymt.leetcode.string.repeated_substring_pattern;

/**
 * @description Solution1简单优化
 * @author yumingtao
 * @date 2022-10-07 14:10
 */
public class Solution2 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        StringBuilder sub = new StringBuilder();
        for (int i = 0; i < len / 2; ++i) {
            sub.append(s.charAt(i));
            //如果字符串的长度不能背子串的长度整除，继续枚举
            if (len % sub.length() != 0) {
                continue;
            }

            String tmp = s.replace(sub.toString(), "");
            if ("".equals(tmp)) {
                return true;
            }
        }
        return false;
    }
}
