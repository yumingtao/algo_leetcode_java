package com.ymt.leetcode.two_pointers.maximum_points_you_can_obtain_from_cards;

/**
 * 思路：前缀和+滑动窗口
 * 1.每次都从头尾，换个四维，每次取中间连续和最小的n-k个数，这样头尾取出的和最大
 *
 * @author yumingtao
 * @date 2021/11/22 19:23
 */
public class Solution2 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] pSum = new int[n + 1];
        int minSlideSum = Integer.MAX_VALUE;

        //计算n-k长度滑动窗口內数组元素和的最小值
        //前缀和数组范围[0,n], 区间和pSum[right+1]-pSum[left];
        //right-left+1=n-k -> left=right+k-n+1
        //i表示right, right+1<=n -> left+n-k<=n ->left<=k
        //所以left的取值范围是[0,k]
        for (int i = 0; i < n; i++) {
            pSum[i + 1] = pSum[i] + cardPoints[i];
            int left = i + k - n + 1;
            if (left >=0  && left <= k) {
                minSlideSum = Math.min(minSlideSum, pSum[i + 1] - pSum[left]);
            }
        }
        return pSum[n] - minSlideSum;
    }
}
