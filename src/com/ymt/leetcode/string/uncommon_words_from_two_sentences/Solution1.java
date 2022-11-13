package com.ymt.leetcode.string.uncommon_words_from_two_sentences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author yumingtao
 * @date 2022-11-13 16:39
 */
public class Solution1 {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String s : s1.split(" ")) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }

        for (String s : s2.split(" ")) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                ans.add(entry.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }
}
