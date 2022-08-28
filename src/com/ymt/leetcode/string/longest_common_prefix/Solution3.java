package com.ymt.leetcode.string.longest_common_prefix;

/**
 * @description
 * @author yumingtao
 * @date 2022-08-28 17:41
 */
public class Solution3 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        //两两找到到最长公共前缀prefix，用prefix依次跟下一个字符串找到最长公共前缀
        String ans = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            ans = getLongestPrefix(ans, strs[i]);
            if (ans.length() == 0) {
                return "";
            }
        }
        return ans;
    }

    private String getLongestPrefix(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        int i = 0;
        while (i < minLen && s1.charAt(i) == s2.charAt(i)) {
            ++i;
        }
        return s1.substring(0, i);
    }
}
