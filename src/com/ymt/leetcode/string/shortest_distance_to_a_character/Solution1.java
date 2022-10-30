package com.ymt.leetcode.string.shortest_distance_to_a_character;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-30 15:33
 */
public class Solution1 {
    public int[] shortestToChar(String s, char c) {
        List<Integer> cIndex = new ArrayList<>();
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; ++i) {
            if (sArr[i] == c) {
                cIndex.add(i);
            }
        }
        int[] ans = new int[sArr.length];
        int cIndexSize = cIndex.size();
        for (int i = 0; i < sArr.length; ++i) {
            if (i <= cIndex.get(0)) {
                ans[i] = Math.abs(cIndex.get(0) - i);
            } else if (i >= cIndex.get(cIndexSize - 1)) {
                ans[i] = Math.abs(i - cIndex.get(cIndexSize - 1));
            } else {
                ans[i] = i - cIndex.get(0);
                for (int j = 1; j < cIndexSize; ++j) {
                    ans[i] = Math.min(ans[i], Math.abs(i - cIndex.get(j)));
                }
            }
        }
        return ans;
    }
}
