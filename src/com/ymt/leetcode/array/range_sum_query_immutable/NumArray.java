package com.ymt.leetcode.array.range_sum_query_immutable;

/**
 * @author yumingtao
 * @date 2021/9/6 21:57
 */
public class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        int n = nums.length;
        sum = new int[n + 1];

        //注意前缀和数组的下标从1开始
        //可以使用sum[i] = sum[i - 1] + nums[i], 但前提是nums变成从以开始
        for(int i = 0; i < n; i++){
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}
