package com.ymt.leetcode.array.contiguous_array;

/**
 * 前缀和+暴力解法，超时
 *
 * @author yumingtao
 * @date 2021/9/17 16:04
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int val = preSum[j] - preSum[i - 1];
                if ((j - i + 1) % 2 == 0 && val == (j - i + 1) / 2) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}
