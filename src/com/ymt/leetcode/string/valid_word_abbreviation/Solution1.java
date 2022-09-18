package com.ymt.leetcode.string.valid_word_abbreviation;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-18 16:22
 */
public class Solution1 {
    public boolean validWordAbbreviation(String word, String abbr) {
        //没有替换任何字符串
        if (word.equals(abbr)) {
            return true;
        }
        int wordLen = word.length();
        //abbr还原到i位置的长度
        int len = 0;
        boolean lastIsChar = false;
        int lastNum = 0;
        for (int i = 0; i < abbr.length(); ++i) {
            char c = abbr.charAt(i);
            if (c >= 'a' && c <= 'z') {//如果是字符
                //lastIsChar置为true
                lastIsChar = true;
                //长度增1
                ++len;
                if (lastNum > 0) {
                    //在i之前存在数字，将数字代表的长度加上，得到当前字符c应该出现在word中的位置
                    len += lastNum;
                    lastNum = 0;
                }
                //如果当前推导出来的长度len大于word的长度，或是word中在len-1位置出现的字符不是c直接返回false
                if (len > wordLen || word.charAt(len - 1) != c) {
                    return false;
                }
            } else {//如果是数字
                if ((lastIsChar || i == 0) && c == '0') {
                    //当i-1位置出现的是字符或c为当前是addr首字符，如果c是'0',说明存在前导0，直接返回false
                    return false;
                } else if (!lastIsChar) {
                    //如果上一个字符是数字，计算上一个字符和当前c代表的整数
                    lastNum = lastNum * 10 + c - '0';
                } else {
                    //如果上一个字符不是数字，计算当前c代表的整数
                    lastNum = c - '0';
                }
                //如果计算出来代表缩写字符的整数超过wordLen，直接返回false
                if (lastNum > wordLen) {
                    return false;
                }
                //lastIsChar置为false
                lastIsChar = false;
            }
        }
        //如果lastNum不等于0，说明abbr是以数字结尾的，len+lastNum为推导出来的word的长度
        len = lastNum == 0 ? len : len + lastNum;
        //判断推导出来的word长度len是否和word实际长度相等
        return wordLen == len;
    }
}
