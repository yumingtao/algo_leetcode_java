package com.ymt.leetcode.string.shortest_word_distance;

/**
 * @Description Solution1优化
 * @author yumingtao
 * @date 2022-10-03 17:32
 */
public class Solution2 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int len = wordsDict.length;
        int p1 = 0;
        //先找到第一次出现word1的位置
        while (p1 < len && !wordsDict[p1].equals(word1)) {
            ++p1;
        }
        int p2 = 0;
        //再找到第一次出现word2的位置
        while (p2 < len && !wordsDict[p2].equals(word2)) {
            ++p2;
        }
        int ans = 30000;
        while (p1 < len && p2 < len) {
            ans = Math.min(Math.abs(p1 - p2), ans);
            if (p1 <= p2) {
                //p1<=p2时，p1去找下一个word1的位置
                ++p1;
                while (p1 < len && !wordsDict[p1].equals(word1)) {
                    ++p1;
                }
            } else {
                //p2<p1时，p2去找下一个word2的位置
                ++p2;
                while (p2 < len && !wordsDict[p2].equals(word2)) {
                    ++p2;
                }
            }
        }

        return ans;
    }
}
