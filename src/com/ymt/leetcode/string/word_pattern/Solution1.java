package com.ymt.leetcode.string.word_pattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-02 12:14
 */
public class Solution1 {
    public boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");
        if (pattern.length() != sArr.length) {
            return false;
        }
        Map<String, String> mapping = new HashMap<>();
        Set<Character> cache = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sArr.length; ++i) {
            if (!mapping.containsKey(sArr[i])) {
                if (cache.contains(pattern.charAt(i))) {
                    return false;
                } else {
                    mapping.put(sArr[i], String.valueOf(pattern.charAt(i)));
                    cache.add(pattern.charAt(i));
                }
            }
            sb.append(mapping.get(sArr[i]));
        }
        return pattern.equals(sb.toString());
    }
}
