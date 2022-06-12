package com.ymt.leetcode.two_pointers.two_sum_less_than_k;

import java.util.Arrays;

/**
 * @author yumingtao
 * @date 2022/2/16 11:03
 */
public class Solution3 {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int ans = -1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < k) {
                ans = Math.max(ans, sum);
                ++i;
            } else {
                --j;
            }
        }
        return ans;
    }
}
