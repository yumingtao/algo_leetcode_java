package com.ymt.leetcode.string.reverse_words_in_a_string_iii;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-16 15:36
 */
public class Solution1 {
    public String reverseWords(String s) {
        char[] chs = s.toCharArray();
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            if (chs[end] == ' ') {
                reverseCharArray(chs, start, end - 1);
                start = end + 1;
                ++end;
            }
            ++end;
        }
        reverseCharArray(chs, start, end - 1);
        return new String(chs);
    }

    private void reverseCharArray(char[] chs, int start, int end) {
        while (start < end) {
            char tmp = chs[end];
            chs[end] = chs[start];
            chs[start] = tmp;
            ++start;
            --end;
        }
    }
}
