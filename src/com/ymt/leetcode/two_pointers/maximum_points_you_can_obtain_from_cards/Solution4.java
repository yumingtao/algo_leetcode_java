package com.ymt.leetcode.two_pointers.maximum_points_you_can_obtain_from_cards;

/**
 * 思路：滑动窗口
 * 1.每次都从头尾，换个四维，每次取中间连续和最小的n-k个数，这样头尾取出的和最大
 *
 * @author yumingtao
 * @date 2021/11/22 20:05
 */
public class Solution4 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        int slideSum = 0;
        int slide = n - k;
        for (int i = 0; i < n; i++) {
            sum += cardPoints[i];
            if (i < slide) {
                slideSum += cardPoints[i];
            }
        }

        int minSlideSum = slideSum;
        for (int i = slide; i < n; i++) {
            slideSum += cardPoints[i] - cardPoints[i - slide];
            minSlideSum = Math.min(minSlideSum, slideSum);
        }

        return sum - minSlideSum;
    }
}
