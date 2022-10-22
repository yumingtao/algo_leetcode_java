package com.ymt.leetcode.string.sentence_similarity;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 题解评论区实现
 * @author yumingtao
 * @date 2022-10-22 16:32
 */
public class Solution3 {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int len1 = sentence1.length;
        int len2 = sentence2.length;
        if (len1 != len2) {
            return false;
        }
        if (similarPairs.size() == 0) {
            //直接比较两个数组对应字符串是否相等
            for (int i = 0; i < len1; ++i) {
                if (!sentence1[i].equals(sentence2[i])) {
                    return false;
                }
            }
            return true;
        } else {
            List<String> l1 = new ArrayList<>();
            List<String> l2 = new ArrayList<>();
            for (int i = 0; i < len1; ++i) {
                if (sentence1[i].equals(sentence2[i])) {
                    continue;
                }
                l1.clear();
                l1.add(sentence1[i]);
                l1.add(sentence2[i]);
                l2.clear();
                l2.add(sentence2[i]);
                l2.add(sentence1[i]);
                if (!similarPairs.contains(l1) && !similarPairs.contains(l2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
