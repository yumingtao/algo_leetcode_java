package com.ymt.leetcode.two_pointers.maximum_points_you_can_obtain_from_cards;

/**
 * 思路：前缀和+滑动窗口
 * 1.每次都从头尾，换个四维，每次取中间连续和最小的n-k个数，这样头尾取出的和最大
 *
 * @author yumingtao
 * @date 2021/11/22 19:16
 */
public class Solution1 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        //先求出数组的前缀和
        int[] pSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pSum[i + 1] = pSum[i] + cardPoints[i];
        }

        //滑动窗口的大小
        int slide = n - k;
        //求slide长度滑动窗的最小值，那么每次从头尾获取的应该就是最大值
        int minSlideSum = Integer.MAX_VALUE;


        //[left, right], 区间和pSum[right+1]-pSum[left]
        //right-left+1=n-k -> right+1=left+n-k;
        //right+1<=n -> left+n-k<=n -> left <= k
        for (int i = 0; i <= k; i++) {
            minSlideSum = Math.min(minSlideSum, pSum[i + slide] - pSum[i]);
        }

        return pSum[n] - minSlideSum;
    }
}
