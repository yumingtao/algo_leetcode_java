package com.ymt.leetcode.string.longest_common_prefix;

/**
 * @description
 * @author yumingtao
 * @date 2022-08-28 17:46
 */
public class Solution4 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        for (int i = 0; i < strs[0].length(); ++i) {
            for (int j = 1; j < strs.length; ++j) {
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
