package com.ymt.leetcode.string.sentence_similarity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description 题解实现
 * @author yumingtao
 * @date 2022-10-22 16:16
 */
public class Solution2 {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int len1 = sentence1.length;
        int len2 = sentence2.length;
        if (len1 != len2) {
            return false;
        }

        Set<String> set = new HashSet<>();
        for (List<String> l : similarPairs) {
            set.add(l.get(0) + "#" + l.get(1));
        }

        for (int i = 0; i < len1; ++i) {
            String key1 = sentence1[i];
            String key2 = sentence2[i];
            if (!key1.equals(key2) && !set.contains(key1 + "#" + key2) && !set.contains(key2 + "#" + key1)) {
                return false;
            }
        }
        return true;
    }
}
