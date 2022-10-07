package com.ymt.leetcode.string.add_strings;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-07 13:41
 */
public class Solution2 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int val = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = a + b + val;
            sb.append(sum % 10);
            val = sum / 10;
            --i;
            --j;
        }
        if (val != 0) {
            sb.append(val);
        }
        return sb.reverse().toString();
    }
}
