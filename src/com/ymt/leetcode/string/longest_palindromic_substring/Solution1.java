package com.ymt.leetcode.string.longest_palindromic_substring;

/**
 * @description 超时了
 * @author yumingtao
 * @date 2022-09-03 14:53
 */
public class Solution1 {
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 1;
        String maxStr = s.substring(0, maxLen);
        for (int i = 0; i < len; ++i) {
            if (len - i + 1 <= maxLen) {
                break;
            }
            int start = maxLen > i ? maxLen : i + 1;
            for (int j = start; j <= len; ++j) {
                if (j - i + 1 <= maxLen) {
                    continue;
                }
                String str = s.substring(i, j);
                String reverseStr = new StringBuilder(str).reverse().toString();
                if (str.equals(reverseStr) && str.length() > maxLen) {
                    maxStr = str;
                    maxLen = str.length();
                }
            }
        }
        return maxStr;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for (int i = chs.length - 1; i >= 0; --i) {
            sb.append(chs[i]);
        }
        return sb.toString();
    }
}
