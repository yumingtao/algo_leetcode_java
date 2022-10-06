package com.ymt.leetcode.string.find_the_difference;

/**
 * @description 题解实现
 * @author yumingtao
 * @date 2022-10-06 12:45
 */
public class Solution3 {
    public char findTheDifference(String s, String t) {
        //利用相同异或为0，任何数和0异或都是其本身的特性
        int ans = 0;
        for (int i = 0; i < t.length(); ++i) {
            ans ^= t.charAt(i);
        }

        for (int i = 0; i < s.length(); ++i) {
            ans ^= s.charAt(i);
        }
        return (char) ans;
    }
}
