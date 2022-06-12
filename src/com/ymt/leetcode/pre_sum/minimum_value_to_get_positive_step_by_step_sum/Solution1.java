package com.ymt.leetcode.pre_sum.minimum_value_to_get_positive_step_by_step_sum;

/**
 * @author yumingtao
 * @date 2021/10/22 15:22
 */
public class Solution1 {
    public int minStartValue(int[] nums) {
        int pSum = 0;
        int minValue = pSum;

        for (int i = 1; i <= nums.length; i++) {
            pSum += nums[i - 1];
            minValue = Math.min(minValue, pSum);
        }

        return minValue <= 0 ? 1 - minValue : minValue;
    }
}
