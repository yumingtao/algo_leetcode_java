package com.ymt.leetcode.array.max_consecutive_ones_iii;

/**
 * 朴素法，超时
 * j < i
 * <p>
 * 当满足一定条件时，求sum[i]-sum[j-1]的max
 * 这个条件是i-j+1-k=sum[i]-sum[j-1]
 *
 * @author yumingtao
 * @date 2021/10/1 21:01
 */
public class Solution1 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];

            for (int j = 1; j <= i; j++) {
                if (i - j + 1 - k <= preSum[i] - preSum[j - 1]) {
                    ans = Math.max(ans, i - j + 1);
                }
            }
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}
