package com.ymt.leetcode.string.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-05 20:21
 */
public class Solution2 {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int ans = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; ++i) {
            int value = roman.get(chs[i]);
            if (i + 1 < chs.length && value < roman.get(chs[i + 1])) {
                value = -value;
            }
            ans += value;
        }
        return ans;
    }
}