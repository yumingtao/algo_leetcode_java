package com.ymt.leetcode.string.valid_word_abbreviation;

/**
 * @description 参看题解，Solution1简单优化
 * @author yumingtao
 * @date 2022-09-18 16:33
 */
public class Solution2 {
    public boolean validWordAbbreviation(String word, String abbr) {
        //没有替换任何字符串
        if (word.equals(abbr)) {
            return true;
        }
        int wordLen = word.length();
        //abbr还原到i位置的长度
        int len = 0;
        int lastNum = 0;
        for (int i = 0; i < abbr.length(); ++i) {
            char c = abbr.charAt(i);
            if (c >= 'a' && c <= 'z') {//如果是字符
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
                if (lastNum == 0 && c == '0') {
                    //当lastNum==0时，说明c可能是abbr首字符或c的前一个字符不是数字，如果c是'0',说明存在前导0，直接返回false
                    return false;
                } else {
                    //计算上一个字符和当前c代表的整数，如果上一个字符不是数字，那么lastNum==0，如果上一个字符是数字，那么也可以用下边的公式计算
                    lastNum = lastNum * 10 + c - '0';
                }
            }
        }
        //如果lastNum不等于0，说明abbr是以数字结尾的，len+lastNum为推导出来的word的长度
        //不管lastNum是否等于0，都可以len + lastNum表示
        //len = lastNum == 0 ? len : len + lastNum;
        //判断推导出来的word长度len是否和word实际长度相等
        return wordLen == len + lastNum;
    }
}
