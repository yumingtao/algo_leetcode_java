package com.ymt.leetcode.string.zuo_xuan_zhuan_zi_fu_chuan_lcof;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-03 20:30
 */
public class Solution1 {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        //如果n是s的长度整数倍，直接返回原字符串
        if (n % len == 0) {
            return s;
        }
        //如果n不是s的长度整数倍，将从左开始n长的字符串拼接到s，后截取
        return s.substring(n, len) + s.substring(0, n);
    }
}
