package com.ymt.leetcode.string.reverse_words_in_a_string_iii;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-16 15:45
 */
public class Solution2 {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; ++i) {
            char[] chs = arr[i].toCharArray();
            int start = 0;
            int end = chs.length - 1;
            while (start < end) {
                char tmp = chs[end];
                chs[end] = chs[start];
                chs[start] = tmp;
                ++start;
                --end;
            }
            arr[i] = new String(chs);
        }
        return String.join(" ", arr);
    }
}
