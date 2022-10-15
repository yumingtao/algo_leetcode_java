package com.ymt.leetcode.string.keyboard_row;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description 暴力
 * @author yumingtao
 * @date 2022-10-15 13:31
 */
public class Solution1 {
    private List<String> cache = new ArrayList<>(Arrays.asList("qwertyuiop", "asdfghjkl", "zxcvbnm"));

    public String[] findWords(String[] words) {
        List<String> ans = new ArrayList<>();
        for (String s : cache) {
            for (String w : words) {
                boolean found = true;
                for (char c : w.toCharArray()) {
                    if (!s.contains(String.valueOf(c).toLowerCase())) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    ans.add(w);
                }
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
