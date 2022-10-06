package com.ymt.leetcode.string.is_subsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-06 13:17
 */
public class Solution1 {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> count = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            if (!count.containsKey(c)) {
                List<Integer> l = new ArrayList<>();
                count.put(c, l);
            }
            count.get(c).add(i);
        }
        int lastCharMinIndex = -1;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!count.containsKey(c)) {
                return false;
            } else {
                boolean found = false;
                for (int k : count.get(c)) {
                    if (k > lastCharMinIndex) {
                        lastCharMinIndex = k;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return false;
                }
            }
        }
        return true;
    }
}
