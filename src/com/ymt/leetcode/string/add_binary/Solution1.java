package com.ymt.leetcode.string.add_binary;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-04 18:34
 */
public class Solution1 {
    public String addBinary(String a, String b) {
        //先补充最短字符串前导0
        int aLen = a.length();
        int bLen = b.length();
        StringBuilder sb = new StringBuilder();
        int val = Math.abs(aLen - bLen);
        while (val > 0) {
            sb.append('0');
            --val;
        }
        if (aLen < bLen) {
            sb.append(a);
            a = sb.toString();
        } else if (aLen > bLen) {
            sb.append(b);
            b = sb.toString();
        }

        char[] aChs = a.toCharArray();
        char[] bChs = b.toCharArray();
        int pA = aChs.length - 1;
        int pB = bChs.length - 1;
        char ch = '0';
        StringBuilder ans = new StringBuilder();
        while (pA >= 0 && pB >= 0) {
            if (aChs[pA] == '1' && bChs[pB] == '1') {
                ans.append(ch);
                ch = '1';
            } else if (aChs[pA] == '0' && bChs[pB] == '0') {
                ans.append(ch);
                ch = '0';
            } else {
                if (ch == '1') {
                    ans.append('0');
                } else {
                    ans.append('1');
                }
            }
            --pA;
            --pB;
        }
        if (ch == '1') {
            ans.append(ch);
        }
        return ans.reverse().toString();
    }
}
