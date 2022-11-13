package com.ymt.leetcode.string.buddy_strings;

/**
 * @description
 * @author yumingtao
 * @date 2022-11-13 15:33
 */
public class Solution1 {
    public boolean buddyStrings(String s, String goal) {
        int sLen = s.length();
        if (sLen != goal.length()) {
            return false;
        }

        char[] sCharArray = s.toCharArray();
        for (int i = 0; i < sLen; ++i) {
            if (i != 0 && sCharArray[i] == sCharArray[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < sLen; ++j) {
                swap(sCharArray, i, j);
                String str = new String(sCharArray);
                if (goal.equals(str)) {
                    return true;
                }
                swap(sCharArray, j, i);
            }
        }
        return false;
    }

    private void swap(char[] chs, int i, int j) {
        char c = chs[i];
        chs[i] = chs[j];
        chs[j] = c;
    }
}
