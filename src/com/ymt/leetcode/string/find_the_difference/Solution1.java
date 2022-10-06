package com.ymt.leetcode.string.find_the_difference;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-06 12:34
 */
public class Solution1 {
    public char findTheDifference(String s, String t) {
        int[] tCount = new int[26];
        for (int i = 0; i < t.length(); ++i) {
            tCount[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); ++i) {
            tCount[s.charAt(i) - 'a']--;
        }

        for (int i = 0; i < tCount.length; ++i) {
            if (tCount[i] > 0) {
                return (char) (i + 'a');
            }
        }
        return ' ';
    }
}
