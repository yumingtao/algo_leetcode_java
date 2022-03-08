package com.ymt.leetcode.map_set.four_sum_ii;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 使用1个map，可以看成是统计两数相加等于0的元组个数
 * @author yumingtao
 * @date 2022/3/8 11:23
 */
public class Solution4 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> firstTwoCountMap = new HashMap<>();
        int n = nums1.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int twoSum = nums1[i] + nums2[j];
                firstTwoCountMap.put(twoSum, firstTwoCountMap.getOrDefault(twoSum, 0) + 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int twoSum = nums3[i] + nums4[j];
                ans += firstTwoCountMap.getOrDefault(-twoSum, 0);
            }
        }
        return ans;
    }
}
