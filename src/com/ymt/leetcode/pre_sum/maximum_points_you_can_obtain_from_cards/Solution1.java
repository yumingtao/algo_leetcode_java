package com.ymt.leetcode.pre_sum.maximum_points_you_can_obtain_from_cards;

/**
 * 思路：
 * 1.每次都从头或尾取出，剩下的数组是连续的
 * 2.先求出前缀和，假设0<=j<=i, 区间和pSum[i]-pSum[j],找长度是n+1-k的区间和最小的值minSubSum
 * 3.用总的点数减去minSubSum
 *
 * @author yumingtao
 * @date 2021/10/22 17:00
 */
public class Solution1 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] pSum = new int[n + 1];
        int minSubSum = Integer.MAX_VALUE;

        int j = -1;
        for (int i = 1; i <= n; i++) {
            pSum[i] = pSum[i - 1] + cardPoints[i - 1];
            //i-j+1=n+1-k -> j=i+k-n
            j = i + k - n;
            //注意区间和下标范围是[0,n]
            if (j >= 0 && j < n) {
                minSubSum = Math.min(minSubSum, pSum[i] - pSum[j]);
            }
        }

        return pSum[n] - minSubSum;
    }
}