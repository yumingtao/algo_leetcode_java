package com.ymt.leetcode.string.detect_capital;

/**
 * @description 参考题解
 * @author yumingtao
 * @date 2022-10-15 15:03
 */
public class Solution3 {
    public boolean detectCapitalUse(String word) {
        //如果只是一个字符，必为true
        if (word.length() == 1) {
            return true;
        }

        //如果第一个字符是小写，第二个字符是大写就返回false
        if (Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        //无论第一个字符是大写还是小写，后边字符必须与第二个字符大小写一致
        boolean secondIsLowerCase = Character.isLowerCase(word.charAt(1));
        for (int i = 2; i < word.length(); ++i) {
            if (secondIsLowerCase ^ Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
