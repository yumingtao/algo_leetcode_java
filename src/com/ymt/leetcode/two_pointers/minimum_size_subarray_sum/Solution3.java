package com.ymt.leetcode.two_pointers.minimum_size_subarray_sum;

/**
 * @author yumingtao
 * @date 2021/12/1 16:40
 */
public class Solution3 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = 1000000000;
        while (right < len) {
            sum += nums[right];
            /*if (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
            }*/
            while (sum >= target) {
                sum -= nums[left];
                minLen = Math.min(minLen, right - left + 1);
                ++left;
            }
            ++right;
        }
        return minLen == 1000000000 ? 0 : minLen;
    }
}
