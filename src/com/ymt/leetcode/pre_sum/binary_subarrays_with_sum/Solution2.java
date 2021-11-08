package com.ymt.leetcode.pre_sum.binary_subarrays_with_sum;

/**
 * @author yumingtao
 * @date 2021/9/29 23:47
 */
public class Solution2 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] count = new int[n + 1];
        count[0] = 1;

        int ans = 0;
        int preSum = 0;
        for (int i = 1; i <= n; i++) {
            //先求出前缀和
            preSum += nums[i - 1];
            //假设j<i, 在[j,i]区间和sum[i]-sum[j-1]=goal
            //sum[j-1]=sum[i]-goal,求在i之前有多少个前缀和的值是sum[i]-goal
            int key = preSum - goal;
            if (key >= 0) {
                ans += count[key];
            }
            count[preSum]++;
        }

        return ans;
    }
}
