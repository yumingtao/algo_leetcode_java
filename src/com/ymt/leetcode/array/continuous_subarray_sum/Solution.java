package com.ymt.leetcode.array.continuous_subarray_sum;

/**
 * 使用前缀和，朴素做法，超时
 *
 * @author yumingtao
 * @date 2021/9/17 11:15
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];

        //先求出数组的前缀和
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        //双重循环判断是否有连续子数组满足条件
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (((sum[j] - sum[i - 1]) % k) == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
