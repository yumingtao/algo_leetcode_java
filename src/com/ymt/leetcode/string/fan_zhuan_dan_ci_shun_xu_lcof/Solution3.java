package com.ymt.leetcode.string.fan_zhuan_dan_ci_shun_xu_lcof;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description 题解，利用语言特性
 * @author yumingtao
 * @date 2022-09-03 12:51
 */
public class Solution3 {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
