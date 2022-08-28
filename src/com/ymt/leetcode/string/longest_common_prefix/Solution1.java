package com.ymt.leetcode.string.longest_common_prefix;

/**
 * @description
 * @author yumingtao
 * @date 2022-08-28 16:43
 */
public class Solution1 {
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
        //如果最短的字符串是""则没有最长公共前缀，直接返回”“
        /*if(shortestStr.equals("")){
            return "";
        }*/

        //假设最短的字符串是最长公共前缀，判断除了自己的所有字符串是否都是以它为前缀，如果不是去掉最后一个字符再次判断
        for (int i = shortestStrLen; i > 0; --i) {
            boolean found = true;
            for (String s : strs) {
                if (!s.equals(shortestStr) && !s.startsWith(shortestStr)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return shortestStr;
            } else {
                shortestStr = shortestStr.substring(0, i - 1);
            }
        }

        return "";
    }

}
