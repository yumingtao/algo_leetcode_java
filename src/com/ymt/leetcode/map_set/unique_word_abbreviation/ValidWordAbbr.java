package com.ymt.leetcode.map_set.unique_word_abbreviation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 使用Map
 * @author yumingtao
 * @date 2022-03-09 19:32
 */
public class ValidWordAbbr {
    private Map<String, List<String>> abbrMap;

    public ValidWordAbbr(String[] dictionary) {
        abbrMap = new HashMap<>();
        for (String s : dictionary) {
            String abbr = getAbbr(s);
            List<String> words = abbrMap.getOrDefault(abbr, new ArrayList<>());
            words.add(s);
            abbrMap.put(abbr, words);
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if (!abbrMap.containsKey(abbr)) {
            return true;
        } else {
            for (String s : abbrMap.get(abbr)) {
                if (!s.equals(word)) {
                    return false;
                }
            }
        }
        return true;
    }

    private String getAbbr(String word) {
        int len = word.length();
        if (len <= 2) {
            return word;
        }
        return new StringBuilder().append(word.charAt(0))
                .append(len - 2)
                .append(word.charAt(len - 1))
                .toString();
    }
}
