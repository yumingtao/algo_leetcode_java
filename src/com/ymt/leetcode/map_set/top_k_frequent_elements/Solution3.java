package com.ymt.leetcode.map_set.top_k_frequent_elements;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 题解评论，直使用Map
 * @author yumingtao
 * @date 2022/3/9 11:07
 */
public class Solution3 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequents = new HashMap<>();
        for (int num : nums) {
            frequents.put(num, frequents.getOrDefault(num, 0) + 1);
        }
        //找到最大频次
        int maxFrequent = 0;
        for (int value : frequents.values()) {
            maxFrequent = Math.max(maxFrequent, value);
        }

        //从最大频次递减，找到小于等于maxFrequent的k个数
        int[] ans = new int[k];
        int index = 0;
        while (index < k) {
            for (int key : frequents.keySet()) {
                if (frequents.get(key) == maxFrequent) {
                    ans[index++] = key;
                }
            }
            --maxFrequent;
        }
        return ans;
    }
}
