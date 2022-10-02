package com.ymt.leetcode.string.count_and_say;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-02 16:16
 */
public class Solution1 {
    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 1; i < n; ++i) {
            ans = describe(ans);
        }
        return ans;
    }

    private String describe(String s) {
        StringBuilder sb = new StringBuilder();
        char ch = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (ch != s.charAt(i)) {
                sb.append(count);
                sb.append(ch);
                ch = s.charAt(i);
                count = 1;
            } else {
                ++count;
            }
        }
        sb.append(count);
        sb.append(ch);
        return sb.toString();
    }
}
