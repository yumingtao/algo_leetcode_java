package com.ymt.leetcode.two_pointers.permutation_in_string;

/**
 * 思路:双指针
 * 主体思想：s1和s2子串(长度是s1Len)中字母统计计数为0时，长度是否为s1Len
 * 1.s1中字母每出现一次减1，初始，s1所有字母计数之和为-s1Len
 * 2.right指针每向右滑动一次，新滑入的字母次数加1
 * 3.s1和s2子串(长度是s1Len)相等的条件是s1和s2子串中中同时出现的字母计数是0
 * 4.当3满足时，如果s2子串的长度刚好是s1Len的时候，有解
 *
 * @author yumingtao
 * @date 2021/12/6 10:17
 */
public class Solution5 {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len > s2Len) {
            return false;
        }

        int[] chCounts = new int[26];
        for (char ch : s1.toCharArray()) {
            --chCounts[ch - 'a'];
        }

        int left = 0;
        int right = 0;
        while (right < s2Len) {
            //滑入的字母索引
            int comeIndex = s2.charAt(right) - 'a';
            ++chCounts[comeIndex];
            //
            while (chCounts[comeIndex] > 0) {
                --chCounts[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == s1Len) {
                return true;
            }
            ++right;
        }

        return false;
    }
}
