package com.ymt.leetcode.string.license_key_formatting;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-07 14:49
 */
public class Solution1 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int charCount = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            if (c == '-') {
                continue;
            }
            if (charCount == k) {
                sb.append("-");
                charCount = 0;
            }
            ++charCount;
            sb.append(String.valueOf(c).toUpperCase());
        }
        return sb.reverse().toString();
    }
}
