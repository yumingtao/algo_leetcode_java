package com.ymt.leetcode.string.palindrome_permutation;

/**
 * @Description 使用数组
 * @author yumingtao
 * @date 2022-10-04 20:42
 */
public class Solution2 {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        char[] chs = s.toCharArray();
        for (char c : chs) {
            count[c - 'a'] += 1;
        }
        boolean hasOddCountChar = false;
        for (int n : count) {
            if (n % 2 == 1) {
                if (hasOddCountChar) {
                    return false;
                } else {
                    hasOddCountChar = true;
                }
            }
        }
        return true;
    }
}
