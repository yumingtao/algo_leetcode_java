package com.ymt.leetcode.string.palindrome_permutation;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 使用哈希表
 * @author yumingtao
 * @date 2022-10-04 20:39
 */
public class Solution1 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> count = new HashMap<>();
        char[] chs = s.toCharArray();
        for (char c : chs) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        boolean hasOddCountChar = false;
        for (int n : count.values()) {
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
