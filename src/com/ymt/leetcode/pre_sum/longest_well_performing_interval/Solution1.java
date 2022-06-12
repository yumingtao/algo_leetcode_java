package com.ymt.leetcode.pre_sum.longest_well_performing_interval;

/**
 * 暴力解法
 *
 * @author yumingtao
 * @date 2021/10/3 21:27
 */
public class Solution1 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] preSum = new int[n + 1];

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            //将数组的值和8比较，>=8 -> 1, <8 -> -1
            int value = hours[i - 1] > 8 ? 1 : -1;

            //求出数组前缀和
            preSum[i] = preSum[i - 1] + value;

            //假设j<=i,求区间和sum[i]-sum[j-1]>0的最大区间长度为解
            for (int j = 1; j <= i; j++) {
                if (preSum[i] - preSum[j - 1] > 0) {
                    ans = Math.max(ans, i - j + 1);
                }
            }
        }

        return ans;
    }
}
