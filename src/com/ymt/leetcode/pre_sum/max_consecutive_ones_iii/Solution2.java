package com.ymt.leetcode.pre_sum.max_consecutive_ones_iii;

/**
 * 前缀和+二分
 * 把1变成0，0变成1，变成区间和不超过k个1
 * left, right
 * preSum[right]-preSum[left-1]<=k -->  preSum[left-1]>=preSum[right]-k
 * 固定right，变成求满足preSum[left-1]>=target的最小的left-1
 * 然后求最大的right-left+1
 * 处理时，两边索引+1，变成preSum[left]>=preSum[right+1]-k
 * 前缀和索引下标从0开始
 *
 * @author yumingtao
 * @date 2021/10/1 21:02
 */
public class Solution2 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            //注意此处1-nums[i-1]是把1变成0，0变成1
            preSum[i] = preSum[i - 1] + 1 - nums[i - 1];
        }

        int ans = Integer.MIN_VALUE;
        for (int r = 0; r < n; r++) {
            int l = binarySearch(preSum, preSum[r + 1] - k);
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

    private int binarySearch(int[] preSum, int target) {
        int l = 0;
        int r = preSum.length;

        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (preSum[mid] >= target) {
                //有可能还在左侧
                r = mid;
            } else {
                //一定在右侧
                l = mid + 1;
            }
        }

        return l;
    }
}
