package com.ymt.leetcode.string.sentence_similarity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-22 16:03
 */
public class Solution1 {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int len1 = sentence1.length;
        int len2 = sentence2.length;
        if (len1 != len2) {
            return false;
        }

        Map<String, StringBuilder> mapping = new HashMap<>();
        for (List<String> l : similarPairs) {
            StringBuilder sb = mapping.getOrDefault(l.get(0), new StringBuilder());
            sb.append(l.get(1));
            mapping.put(l.get(0), sb);
            sb = mapping.getOrDefault(l.get(1), new StringBuilder());
            sb.append(l.get(0));
            mapping.put(l.get(1), sb);
        }

        for (int i = 0; i < len1; ++i) {
            String key1 = sentence1[i];
            String key2 = sentence2[i];
            if (!key1.equals(key2) && !isEquals(mapping, key1, key2) && !isEquals(mapping, key2, key1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isEquals(Map<String, StringBuilder> mapping, String key1, String key2) {
        return mapping.containsKey(key1) && mapping.get(key1).toString().contains(key2);
    }
}
