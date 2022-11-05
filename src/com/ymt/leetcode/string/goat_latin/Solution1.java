package com.ymt.leetcode.string.goat_latin;

/**
 * @description
 * @author yumingtao
 * @date 2022-11-05 15:56
 */
public class Solution1 {
    private final String VOWELS = "aeiouAEIOU";

    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < words.length; ++i) {
            char firstChar = words[i].charAt(0);
            if (!isVowel(firstChar)) {
                ans.append(words[i].substring(1, words[i].length())).append(firstChar);
            } else {
                ans.append(words[i]);
            }
            ans.append(getMa(i));
            if (i != words.length - 1) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }

    private boolean isVowel(char ch) {
        return VOWELS.contains(String.valueOf(ch));
    }

    private String getMa(int index) {
        StringBuilder sb = new StringBuilder("ma");
        while (index >= 0) {
            sb.append('a');
            --index;
        }
        return sb.toString();
    }
}
