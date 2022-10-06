package com.ymt.leetcode.string.strobogrammatic_number;

/**
 * @Description Solution1优化
 * @author yumingtao
 * @date 2022-10-03 20:37
 */
public class Solution2 {
    private final String[] excludes = {"2", "3", "4", "5", "7"};

    public boolean isStrobogrammatic(String num) {
        for (String s : excludes) {
            if (num.contains(s)) {
                return false;
            }
        }
        int len = num.length();
        char[] chs = num.toCharArray();
        int n = len / 2;
        for (int i = 0; i < n; ++i) {
            char ch = changeNum(chs[i]);
            int j = len - i - 1;
            chs[i] = changeNum(chs[j]);
            chs[j] = ch;
        }
        if (len % 2 == 1 && (chs[n] == '6' || chs[n] == '9')) {
            chs[n] = changeNum(chs[n]);
        }
        String newNum = new String(chs);
        return num.equals(newNum);
    }

    private char changeNum(char ch) {
        if (ch == '6') {
            return '9';
        } else if (ch == '9') {
            return '6';
        }
        return ch;
    }
}
