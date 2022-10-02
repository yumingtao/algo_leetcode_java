package com.ymt.leetcode.string.word_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-02 13:32
 */
public class Solution2 {
    public boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");
        if (pattern.length() != sArr.length) {
            return false;
        }
        Map<Object, Integer> mapping = new HashMap<>();
        for (Integer i = 0; i < sArr.length; ++i) {
            if (mapping.put(pattern.charAt(i), i) != mapping.put(sArr[i], i)) {
                return false;
            }
        }
        return true;
    }
}
