package com.ymt.leetcode.two_pointers.permutation_in_string;

/**
 * 思路：滑窗
 * 1. 通过一个数组和不同字母计数
 *
 * @author yumingtao
 * @date 2021/12/3 17:00
 */
public class Solution4 {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len > s2Len) {
            return false;
        }

        int[] chCounts = new int[26];
        for (int i = 0; i < s1Len; i++) {
            --chCounts[s1.charAt(i) - 'a'];
            ++chCounts[s2.charAt(i) - 'a'];
        }

        //不同字符的数量
        int diff = 0;
        for (int c : chCounts) {
            if (c != 0) {
                ++diff;
            }
        }

        if (diff == 0) {
            return true;
        }

        for (int i = s1Len; i < s2Len; i++) {
            //新滑入的字母index
            int comeIndex = s2.charAt(i) - 'a';
            //滑出字母的index
            int outIndex = s2.charAt(i - s1Len) - 'a';
            //如果滑入和滑出是一样的字母，diff不用变化，继续循环
            if (comeIndex == outIndex) {
                continue;
            }

            //在统计滑入字母计数前，如果该字母的计数是0，那么加1之后，diff肯定会增加1
            if (chCounts[comeIndex] == 0) {
                ++diff;
            }
            ++chCounts[comeIndex];
            //在统计滑入字母计数后，如果该字母的计数是0，那么diff需要减1
            if (chCounts[comeIndex] == 0) {
                --diff;
            }

            if (chCounts[outIndex] == 0) {
                ++diff;
            }
            --chCounts[outIndex];
            if (chCounts[outIndex] == 0) {
                --diff;
            }

            if (diff == 0) {
                return true;
            }
        }

        return false;
    }
}
