package com.ymt.leetcode.pre_sum.running_sum_of_1d_array;

/**
 * @author yumingtao
 * @date 2021/10/25 10:12
 */
public class Solution1 {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] pSum = new int[n];
        pSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pSum[i] = pSum[i - 1] + nums[i];
        }

        return pSum;
    }
}
