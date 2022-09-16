package com.ymt.leetcode.string.substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-15 17:04
 */
public class Solution1 {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int allWordsLen = wordLen * words.length;
        if (allWordsLen > s.length()) {
            return Collections.emptyList();
        }
        //先统计words中单数计数
        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }
        //使用滑动窗口截取words.length * words[0].length()的字符串
        //统计字符串中单词出现的个数是否和wordCount中出现的一致
        int left = 0;
        int right = allWordsLen;
        List<Integer> ans = new ArrayList<>();
        while (right <= s.length()) {
            String str = s.substring(left, right);
            Map<String, Integer> slideWordCount = new HashMap<>();
            for (int i = 0; i < str.length(); i += wordLen) {
                String temp = str.substring(i, i + wordLen);
                slideWordCount.put(temp, slideWordCount.getOrDefault(temp, 0) + 1);
            }
            if (wordCount.equals(slideWordCount)) {
                ans.add(left);
            }
            ++left;
            ++right;
        }
        return ans;
    }
}
