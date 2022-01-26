package com.ymt.leetcode.two_pointers.reverse_vowels_of_a_string;

/**
 * @Description 双指针对撞
 * @author yumingtao
 * @date 2022-01-26 19:32
 */
public class Solution1 {
    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!isVowel(chs[left])) {
                ++left;
                continue;
            }
            if (!isVowel(chs[right])) {
                --right;
                continue;
            }
            char tmp = chs[right];
            chs[right] = chs[left];
            chs[left] = tmp;
            ++left;
            --right;
        }
        return String.valueOf(chs);
    }

    private boolean isVowel(char ch) {
        char lowCaseCh = Character.toLowerCase(ch);
        if (lowCaseCh == 'a' || lowCaseCh == 'e' || lowCaseCh == 'i' || lowCaseCh == 'o' || lowCaseCh == 'u') {
            return true;
        }
        return false;
    }
}
