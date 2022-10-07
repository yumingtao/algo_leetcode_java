package com.ymt.leetcode.string.repeated_substring_pattern;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-07 14:02
 */
public class Solution1 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 0; i < len - 1; ++i) {
            int subLen = i + 1;
            //如果字符串的长度不能背子串的长度整除，继续枚举
            if (len % subLen != 0) {
                continue;
            }
            String sub = s.substring(0, subLen);
            String tmp = s.replace(sub, "");
            if ("".equals(tmp)) {
                return true;
            }
        }
        return false;
    }
}
