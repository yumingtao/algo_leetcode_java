package com.ymt.leetcode.two_pointers.maximum_average_subarray_i;

/**
 * @author yumingtao
 * @date 2021/11/22 09:27
 */
public class Solution1 {
    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        int maxWindowSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum + nums[i] - nums[i - k];
            maxWindowSum = Math.max(maxWindowSum, windowSum);
        }

        return (maxWindowSum + 0.0) / k;
    }
}
