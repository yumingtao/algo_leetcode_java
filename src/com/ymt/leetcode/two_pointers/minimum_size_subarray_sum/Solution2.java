package com.ymt.leetcode.two_pointers.minimum_size_subarray_sum;

/**
 * 思路:暴力
 *
 * @author yumingtao
 * @date 2021/12/1 16:23
 */
public class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int minLen = 1000000000;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        return minLen == 1000000000 ? 0 : minLen;
    }
}
