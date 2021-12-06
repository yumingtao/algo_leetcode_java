package com.ymt.leetcode.two_pointers.permutation_in_string;

import java.util.Arrays;

/**
 * 思路：滑窗的另一种写法
 *
 * @author yumingtao
 * @date 2021/12/3 15:40
 */
public class Solution2 {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len > s2Len) {
            return false;
        }

        //s1的长度为滑动窗口的长度
        //使用计数数组，预处理统计s1的字母统计和s2中初始长度滑动窗口內的字母统计
        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];
        for (int i = 0; i < s1Len; i++) {
            ++s1Counts[s1.charAt(i) - 'a'];
            ++s2Counts[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(s1Counts, s2Counts)) {
            return true;
        }

        //继续判断从n开始到s2Len的子串是否满足要求
        for (int i = s1Len; i < s2Len; i++) {
            //统计新滑入的字母计数
            ++s2Counts[s2.charAt(i) - 'a'];
            //减去滑出的字母计数
            --s2Counts[s2.charAt(i - s1Len) - 'a'];
            if (Arrays.equals(s1Counts, s2Counts)) {
                return true;
            }
        }
        return false;
    }
}
