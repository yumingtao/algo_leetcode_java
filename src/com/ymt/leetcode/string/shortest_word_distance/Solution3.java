package com.ymt.leetcode.string.shortest_word_distance;

/**
 * @Description 参考题解
 * @author yumingtao
 * @date 2022-10-03 17:49
 */
public class Solution3 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int len = wordsDict.length;
        int p1 = -1;
        int p2 = -1;
        int ans = len;
        for (int i = 0; i < len; ++i) {
            if (word1.equals(wordsDict[i])) {
                p1 = i;
            }
            if (word2.equals(wordsDict[i])) {
                p2 = i;
            }
            if (p1 >= 0 && p2 >= 0) {
                ans = Math.min(ans, Math.abs(p1 - p2));
            }
        }

        return ans;
    }
}
