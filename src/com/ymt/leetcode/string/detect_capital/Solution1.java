package com.ymt.leetcode.string.detect_capital;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-15 14:49
 */
public class Solution1 {
    private final String LOWER_CASE = "abcdefghijklmnopqrstwvuxyz";
    private final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTWVUXYZ";

    public boolean detectCapitalUse(String word) {
        String firstLetter = String.valueOf(word.charAt(0));
        if (UPPER_CASE.contains(firstLetter)) {
            boolean leftAllUpperCase = true;
            boolean leftAllLowerCase = true;
            for (int i = 1; i < word.length(); ++i) {
                String currLetter = String.valueOf(word.charAt(i));
                if (UPPER_CASE.contains(currLetter)) {
                    leftAllLowerCase = false;
                }
                if (LOWER_CASE.contains(currLetter)) {
                    leftAllUpperCase = false;
                }
            }
            return leftAllLowerCase || leftAllUpperCase;
        } else {
            for (int i = 1; i < word.length(); ++i) {
                String currLetter = String.valueOf(word.charAt(i));
                if (UPPER_CASE.contains(currLetter)) {
                    return false;
                }
            }
        }
        return true;
    }
}
