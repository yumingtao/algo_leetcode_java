package com.ymt.leetcode.array.subarray_sums_divisible_by_k;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yumingtao
 * @date 2021/9/30 01:04
 */
public class Solution1 {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);

        int ans = 0;
        int preSum = 0;
        for (int i = 1; i <= n; i++) {
            preSum += nums[i - 1];

            // 注意当被除数为负数时取模结果为负数，需要纠正
            int key = (preSum % k + k) % k;
            int count = countMap.getOrDefault(key, 0);
            ans += count;
            countMap.put(key, count + 1);
        }

        System.out.println(4 % 5);
        return ans;
    }
}
