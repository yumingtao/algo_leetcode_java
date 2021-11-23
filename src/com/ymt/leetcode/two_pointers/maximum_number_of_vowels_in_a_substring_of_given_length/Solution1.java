package com.ymt.leetcode.two_pointers.maximum_number_of_vowels_in_a_substring_of_given_length;

import java.util.HashSet;
import java.util.Set;

/**
 * 思路：滑动窗口
 *
 * @author yumingtao
 * @date 2021/11/23 10:02
 */
public class Solution1 {
    public int maxVowels(String s, int k) {
        Set<Character> vowelSet = new HashSet<Character>() {
            {
                add('a');
                add('e');
                add('i');
                add('o');
                add('u');
            }
        };
        char[] vowels = s.toCharArray();
        int vowelsLen = 0;
        for (int i = 0; i < k; i++) {
            if (vowelSet.contains(vowels[i])) {
                vowelsLen++;
            }
        }

        int maxVowelsLen = vowelsLen;
        for (int i = k; i < vowels.length; i++) {
            if (vowelSet.contains(vowels[i])) {
                vowelsLen++;
            }

            if (vowelSet.contains(vowels[i - k])) {
                vowelsLen--;
            }

            maxVowelsLen = Math.max(maxVowelsLen, vowelsLen);
        }

        return  maxVowelsLen;
    }
}
