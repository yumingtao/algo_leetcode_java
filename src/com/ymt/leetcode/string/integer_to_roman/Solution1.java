package com.ymt.leetcode.string.integer_to_roman;

import java.util.Map;
import java.util.TreeMap;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-14 12:22
 */
public class Solution1 {
    public String intToRoman(int num) {
        Map<Integer, String> roman = new TreeMap<>((o1, o2) -> o2 - o1);
        roman.put(1000, "M");
        roman.put(900, "CM");
        roman.put(500, "D");
        roman.put(400, "CD");
        roman.put(100, "C");
        roman.put(90, "XC");
        roman.put(50, "L");
        roman.put(40, "XL");
        roman.put(10, "X");
        roman.put(9, "IX");
        roman.put(5, "V");
        roman.put(4, "IV");
        roman.put(1, "I");

        String ans = "";
        for (Integer key : roman.keySet()) {
            int val = num / key;
            if (val > 0) {
                while (val > 0) {
                    ans += roman.get(key);
                    --val;
                }
                num = num % key;
            }
        }
        return ans;
    }
}
