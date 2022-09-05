package com.ymt.leetcode.string.add_binary;

/**
 * @description Solution1简单优化
 * @author yumingtao
 * @date 2022-09-04 18:35
 */
public class Solution2 {
    public String addBinary(String a, String b) {
        //先补充最短字符串前导0
        StringBuilder sb = new StringBuilder();
        int val = Math.abs(a.length() - b.length());
        while (val > 0) {
            sb.append('0');
            --val;
        }
        if (a.length() < b.length()) {
            sb.append(a);
            a = sb.toString();
        } else if (a.length() > b.length()) {
            sb.append(b);
            b = sb.toString();
        }

        char[] aChs = a.toCharArray();
        char[] bChs = b.toCharArray();
        int p = aChs.length - 1;
        char ch = '0';
        sb.delete(0, sb.length());
        while (p >= 0) {
            if (aChs[p] == bChs[p]) {
                sb.append(ch);
                ch = aChs[p];
            } else if (ch == '1') {
                sb.append('0');
            } else {
                sb.append('1');
            }
            --p;
        }
        if (ch == '1') {
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
}
