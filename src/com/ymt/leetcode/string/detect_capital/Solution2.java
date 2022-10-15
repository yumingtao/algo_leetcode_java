package com.ymt.leetcode.string.detect_capital;

/**
 * @description Solution1简单优化
 * @author yumingtao
 * @date 2022-10-15 15:02
 */
public class Solution2 {
    public boolean detectCapitalUse(String word) {
        if (Character.isUpperCase(word.charAt(0))) {
            boolean leftAllUpperCase = true;
            boolean leftAllLowerCase = true;
            for (int i = 1; i < word.length(); ++i) {
                if (Character.isUpperCase(word.charAt(i))) {
                    leftAllLowerCase = false;
                }
                if (Character.isLowerCase(word.charAt(i))) {
                    leftAllUpperCase = false;
                }
            }
            return leftAllLowerCase || leftAllUpperCase;
        } else {
            for (int i = 1; i < word.length(); ++i) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
