package com.ymt.leetcode.string.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-05 20:20
 */
public class Solution1 {
    public int romanToInt(String s) {
        Map<String, Integer> roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);
        roman.put("IV", 4);
        roman.put("IX", 9);
        roman.put("IV", 4);
        roman.put("XL", 40);
        roman.put("XC", 90);
        roman.put("CD", 400);
        roman.put("CM", 900);
        int len = s.length();
        int ans = 0;
        int i = 0;
        while(i + 2 <= len){
            String str = s.substring(i, i + 2);
            if(roman.containsKey(str)){
                ans += roman.get(str);
                i += 2;
            }else{
                ans += roman.get(s.substring(i, i + 1));
                ++i;
            }
        }
        if(i < len){
            ans += roman.get(s.substring(i, len));
        }
        return ans;
    }
}
