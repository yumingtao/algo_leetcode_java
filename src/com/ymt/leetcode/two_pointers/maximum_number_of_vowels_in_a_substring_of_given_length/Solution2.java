package com.ymt.leetcode.two_pointers.maximum_number_of_vowels_in_a_substring_of_given_length;

/**
 * 思路：滑动窗口
 *
 * @author yumingtao
 * @date 2021/11/23 10:21
 */
public class Solution2 {
    public int maxVowels(String s, int k) {
        int vowelsLen = 0;
        for (int i = 0; i < k; i++) {
            vowelsLen += isVowel(s.charAt(i));
        }

        int maxVowelsLen = vowelsLen;
        for (int i = k; i < s.length(); i++) {
            vowelsLen += isVowel(s.charAt(i)) - isVowel(s.charAt(i - k));
            maxVowelsLen = Math.max(maxVowelsLen, vowelsLen);
        }

        return maxVowelsLen;
    }

    private int isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') ? 1 : 0;
    }
}
