package com.ymt.leetcode.string.unique_morse_code_words;

import java.util.HashSet;
import java.util.Set;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-29 16:54
 */
public class Solution1 {
    private final String[] MORSE_CODES = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-" +
            ".-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
            "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> codeSet = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(MORSE_CODES[c - 'a']);
            }
            codeSet.add(sb.toString());
        }
        return codeSet.size();
    }
}
