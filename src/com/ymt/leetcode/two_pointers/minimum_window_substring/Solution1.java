package com.ymt.leetcode.two_pointers.minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：暴力解法, 时间复杂度O(n^3),会超时
 *
 * @author yumingtao
 * @date 2021/11/24 08:52
 */
public class Solution1 {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if(sLen < tLen){
            return "";
        }

        if(sLen == tLen){
            if(!isContains(s, t)){
                return "";
            }
        }

        int minLen = sLen;
        String minStr = "";
        for (int i = 0; i <= sLen - tLen; i++) {
            for (int j = i + tLen; j <= sLen; j++) {
                String subStr = s.substring(i, j);
                if (isContains(subStr, t)) {
                    if (minLen >= subStr.length()) {
                        minLen = subStr.length();
                        minStr = subStr;
                    }
                }
            }
        }

        return minStr;
    }

    private boolean isContains(String s, String t) {
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();
        for (char ch : s.toCharArray()) {
            sCount.put(ch, sCount.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
           tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);
        }

        for(char ch : tCount.keySet()){
            if(!sCount.containsKey(ch)){
                return false;
            }

            if(sCount.get(ch).intValue() < tCount.get(ch).intValue()){
                return false;
            }
        }
        return true;
    }
}
