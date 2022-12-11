package com.ymt.leetcode.string.find_common_characters;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author yumingtao
 * @date 2022-12-11 23:41
 */
public class Solution1 {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        // 统计每个字符串中字母的计数
        int a[][] = new int[n][26];
        for (int i = 0; i < n; ++i) {
            for (char c : words[i].toCharArray()) {
                a[i][c - 'a']++;
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            int minCount = 101;
            char c = (char) (i + 'a');
            boolean found = true;
            for (int j = 0; j < n; ++j) {
                if (a[j][i] == 0) {
                    found = false;
                    break;
                }
                minCount = Math.min(minCount, a[j][i]);
            }
            if (found) {
                while (minCount > 0) {
                    ans.add(String.valueOf(c));
                    --minCount;
                }
            }
        }
        return ans;
    }
}
