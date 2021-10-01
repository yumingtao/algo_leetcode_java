package com.ymt.leetcode.array.max_consecutive_ones_iii;

/**
 * 前缀和+滑动窗口
 *
 * @author yumingtao
 * @date 2021/10/1 21:25
 */
public class Solution3 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            //注意此处1-nums[i-1]是把1变成0，0变成1
            preSum[i] = preSum[i - 1] + 1 - nums[i - 1];
        }

        int ans = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        while (r < n) {
            while (r < n && preSum[r + 1] - preSum[l] <= k) {
                r++;
            }

            //因为r++时多+1，所以应该是 ans = Math.max(ans, (r - 1) - l + 1);
            ans = Math.max(ans, r - l);

            if (l < n && r != n) {
                l++;
            }
        }

        return ans;
    }
}
