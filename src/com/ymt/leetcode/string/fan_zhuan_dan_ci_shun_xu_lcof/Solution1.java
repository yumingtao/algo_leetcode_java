package com.ymt.leetcode.string.fan_zhuan_dan_ci_shun_xu_lcof;

/**
 * @description
 * @author yumingtao
 * @date 2022-08-28 18:22
 */
public class Solution1 {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        String[] arr = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (!arr[i].equals("")) {
                ans.append(arr[i]);
                ans.append(" ");
            }
        }
        String str = ans.toString();
        return str.equals("") ? "" : str.substring(0, str.length() - 1);
    }
}
