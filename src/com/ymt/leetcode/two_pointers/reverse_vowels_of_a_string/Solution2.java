package com.ymt.leetcode.two_pointers.reverse_vowels_of_a_string;

/**
 * @Description 题解
 * @author yumingtao
 * @date 2022-01-26 19:48
 */
public class Solution2 {
    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < s.length() - 1 && !isVowel(chs[left])) {
                ++left;
            }
            while (right > 0 && !isVowel(chs[right])) {
                --right;
            }
            if (left < right) {
                char tmp = chs[right];
                chs[right] = chs[left];
                chs[left] = tmp;
                ++left;
                --right;
            }
        }
        return String.valueOf(chs);
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }
}
