package com.ymt.leetcode.pre_sum.max_consecutive_ones_iii;

/**
 * 前缀和+双指针优化
 *
 * @author yumingtao
 * @date 2021/10/1 21:38
 */
public class Solution4 {
    public int longestOnes(int[] nums, int k) {
        int ans = Integer.MIN_VALUE;
        int lSum = 0;
        int rSum = 0;
        int l = 0;

        //preSum[l]>=preSum[r+1]-k
        for (int r = 0; r < nums.length; r++) {
            //注意此处1-nums[i-1]是把1变成0，0变成1
            rSum += 1 - nums[r];

            //说明l小了，需要++
            while (lSum < rSum - k) {
                lSum += 1 - nums[l];
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
