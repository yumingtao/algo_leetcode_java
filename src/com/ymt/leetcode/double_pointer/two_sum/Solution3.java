package com.ymt.leetcode.double_pointer.two_sum;

/**
 * 思路：暴力
 *
 * @author yumingtao
 * @date 2021/11/10 11:27
 */
public class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }
}
