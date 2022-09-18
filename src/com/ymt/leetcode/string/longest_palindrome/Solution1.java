package com.ymt.leetcode.string.longest_palindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-16 17:08
 */
public class Solution1 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int ans = 0;
        boolean hasOdd = false;
        for (char key : count.keySet()) {
            ans += count.get(key) / 2;
            if (hasOdd == false && count.get(key) % 2 == 1) {
                hasOdd = true;
            }
        }

        return hasOdd ? ans * 2 + 1 : ans * 2;
    }
}
