package com.ymt.leetcode.two_pointers.number_of_subarrays_with_bounded_maximum;

/**
 * @Description 官方题解
 * @author yumingtao
 * @date 2022-01-09 17:57
 */
public class Solution3 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return getCount(nums, right) - getCount(nums, left);
    }

    private int getCount(int[] nums, int max) {
        int ans = 0;
        int count = 0;
        for (int num : nums) {
            if (num <= max) {
                ++count;
                ans += count;
            }else {
                count = 0;
            }
        }
        return ans;
    }
}
