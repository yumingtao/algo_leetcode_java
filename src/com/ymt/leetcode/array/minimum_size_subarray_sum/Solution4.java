package com.ymt.leetcode.array.minimum_size_subarray_sum;

/**
 * 双指针
 *
 * @author yumingtao
 * @date 2021/9/14 20:25
 */
public class Solution4 {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }

            end++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
