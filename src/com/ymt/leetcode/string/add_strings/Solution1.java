package com.ymt.leetcode.string.add_strings;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-07 12:37
 */
public class Solution1 {
    public String addStrings(String num1, String num2) {
        if ("0".equals(num1)) {
            return num2;
        }

        if ("0".equals(num2)) {
            return num1;
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int maxLen = len1 >= len2 ? len1 + 1 : len2 + 1;
        int[] arr = new int[maxLen];
        char[] chs1 = num1.toCharArray();
        for (int i = len1 - 1; i >= 0; --i) {
            arr[maxLen - len1 + i] = chs1[i] - '0';
        }

        char[] chs2 = num2.toCharArray();
        int val = 0;
        for (int i = maxLen - 1; i >= 0; --i) {
            int sum = arr[i] + val;
            if (i >= maxLen - len2) {
                sum += chs2[i - maxLen + len2] - '0';
            }
            arr[i] = sum % 10;
            val = sum / 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            if (num == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(num);
        }
        return sb.toString();
    }
}
