package com.ymt.leetcode.two_pointers.maximum_points_you_can_obtain_from_cards;

/**
 * 思路：前缀和+滑动窗口
 * 1.每次都从头尾，换个四维，每次取中间连续和最小的n-k个数，这样头尾取出的和最大
 *
 * @author yumingtao
 * @date 2021/11/22 19:53
 */
public class Solution3 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] pSum = new int[n + 1];
        int minSlideSum = Integer.MAX_VALUE;

        //right-left+1=n-k -> left=right+1+k-n;
        //right+1就是i -> left=k-n+1
        //right+1<=n -> left+n-k<=n -> left<=k
        for (int i = 1; i <= n; i++) {
            pSum[i] = pSum[i - 1] + cardPoints[i - 1];
            int left = k - n + 1;
            if (left >= 0 && left <= k) {
                minSlideSum = Math.min(minSlideSum, pSum[i] - pSum[left]);
            }
        }

        return pSum[n] - minSlideSum;
    }
}
