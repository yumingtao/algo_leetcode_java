package com.ymt.leetcode.string.buddy_strings;

/**
 * @description
 * @author yumingtao
 * @date 2022-11-13 16:26
 */
public class Solution2 {
    public boolean buddyStrings(String s, String goal) {
        int sLen = s.length();
        if (sLen != goal.length()) {
            return false;
        }
        int first = -1;
        int second = -1;
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < sLen; ++i) {
                int index = s.charAt(i) - 'a';
                ++count[index];
                if (count[index] > 1) {
                    // 重复字符串
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 0; i < sLen; ++i) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }
        }

        return second != -1 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first);
    }
}
