package com.ymt.leetcode.string.simplify_path;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-02 17:22
 */
public class Solution1 {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        StringBuilder ans = new StringBuilder("/");
        for (String s : arr) {
            if (s.equals("") || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (ans.length() > 2) {
                    String str = ans.substring(0, ans.lastIndexOf("/", ans.length() - 2) + 1);
                    ans = new StringBuilder(str);
                }
                continue;
            }
            ans.append(s);
            ans.append("/");
        }
        if (ans.length() > 1) {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }
}
