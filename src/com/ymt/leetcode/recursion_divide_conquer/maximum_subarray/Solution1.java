package com.ymt.leetcode.recursion_divide_conquer.maximum_subarray;

/**
 * @Description 使用前缀和可解，但是超出时间限制，复杂度O(n^2)
 * @author yumingtao
 * @date 2022-04-04 12:46
 */
public class Solution1 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; ++i) {
            for (int j = i; j < n + 1; ++j) {
                max = Math.max(max, preSum[j] - preSum[i - 1]);
            }
        }
        return max;
    }
}
