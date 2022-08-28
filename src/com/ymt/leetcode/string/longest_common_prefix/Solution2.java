package com.ymt.leetcode.string.longest_common_prefix;

/**
 * @description
 * @author yumingtao
 * @date 2022-08-28 16:43
 */
public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        //循环数组找到最短的字符串,最短的字符串可能有多个，找到其中一个即可
        String shortestStr = "";
        int shortestStrLen = 201;
        for (String s : strs) {
            if (s.length() < shortestStrLen) {
                shortestStrLen = s.length();
                shortestStr = s;
            }
        }

        //假设最短的字符串是最长公共前缀，判断除了自己的所有字符串是否都是以它为前缀，如果不是去掉最后一个字符再次判断
        String ans = "";
        for (int i = 0; i < shortestStrLen; ++i) {
            ans += shortestStr.charAt(i);
            for (String s : strs) {
                if (!s.startsWith(ans)) {
                    return ans.substring(0, i);
                }
            }
        }
        return ans;
    }
}
