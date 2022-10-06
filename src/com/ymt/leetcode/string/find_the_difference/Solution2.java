package com.ymt.leetcode.string.find_the_difference;

/**
 * @description 题解实现
 * @author yumingtao
 * @date 2022-10-06 12:39
 */
public class Solution2 {
    public char findTheDifference(String s, String t) {
        int sCount = 0;
        int tCount = 0;
        for (int i = 0; i < t.length(); ++i) {
            tCount += t.charAt(i);
        }

        for (int i = 0; i < s.length(); ++i) {
            sCount += s.charAt(i);
        }

        return (char) (tCount - sCount);
    }
}
