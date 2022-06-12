package com.ymt.leetcode.map_set.jewels_and_stones;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 使用集合和映射
 * @author yumingtao
 * @date 2022-03-06 14:26
 */
public class Solution1 {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsSet = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewelsSet.add(c);
        }
        int jewelsCount = 0;
        for (char c : stones.toCharArray()) {
            if (jewelsSet.contains(c)) {
                ++jewelsCount;
            }
        }
        return jewelsCount;
    }
}
