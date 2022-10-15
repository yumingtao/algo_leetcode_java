package com.ymt.leetcode.string.keyboard_row;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 题解方法
 * @author yumingtao
 * @date 2022-10-15 14:18
 */
public class Solution2 {
    public String[] findWords(String[] words) {
        List<String> ans = new ArrayList<>();
        String index = "12210111011122000010020202";
        for (String w : words) {
            int currIndex = index.charAt(w.toLowerCase().charAt(0) - 'a');
            boolean found = true;
            for (int i = 1; i < w.length(); ++i) {
                int idx = index.charAt(w.toLowerCase().charAt(i) - 'a');
                if (idx != currIndex) {
                    found = false;
                    break;
                }
            }
            if (found) {
                ans.add(w);
            }
        }
        return ans.toArray(new String[0]);
    }
}
