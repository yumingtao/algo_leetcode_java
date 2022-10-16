package com.ymt.leetcode.string.reverse_words_in_a_string_iii;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-16 15:44
 */
public class Solution3 {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(new StringBuilder(str).reverse()).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
