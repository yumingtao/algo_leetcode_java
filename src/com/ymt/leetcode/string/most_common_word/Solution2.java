package com.ymt.leetcode.string.most_common_word;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description Solution1简单优化
 * @author yumingtao
 * @date 2022-10-29 17:58
 */
public class Solution2 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word);
        }
        Map<String, Integer> wordCount = new HashMap<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < paragraph.length(); ++i) {
            char c = paragraph.charAt(i);
            if (Character.isLetter(c)) {
                word.append(c);
            } else if (word.length() > 0) {
                String wordString = word.toString().toLowerCase();
                if (!bannedSet.contains(wordString)) {
                    wordCount.put(wordString, wordCount.getOrDefault(wordString, 0) + 1);
                }
                word.delete(0, word.length());
            }
        }
        if (word.length() > 0) {
            String wordString = word.toString().toLowerCase();
            if (!bannedSet.contains(wordString)) {
                wordCount.put(wordString, wordCount.getOrDefault(wordString, 0) + 1);
            }
        }
        String ans = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (maxCount < entry.getValue()) {
                maxCount = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
