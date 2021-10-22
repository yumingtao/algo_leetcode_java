package com.ymt.leetcode.array.maximum_points_you_can_obtain_from_cards;

/**
 * 思路:
 * 1.每次都从头或尾取出，剩下的数组是连续的
 * 2.找到n-k长度滑动窗口的最小值minSlidSum
 * 3.用总的点数减去minSlidSum
 *
 * @author yumingtao
 * @date 2021/10/22 19:08
 */
public class Solution2 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int slidSize = n - k;
        //先计算点数总和和初始n-k滑窗的点数总和
        int totalSum = 0;
        int slidSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += cardPoints[i];
            if (i < slidSize) {
                slidSum += cardPoints[i];
            }
        }

        //此时左指针在0的位置，右指针在k-1的位置
        //向右移动右指针，每移动一位，minSlidSum减去左侧的滑出的值，加上右侧滑入的值
        //找到滑动过程中最小的minSlidSum
        int minSlidSum = slidSum;
        for (int i = slidSize; i < n; i++) {
            slidSum = slidSum - cardPoints[i - slidSize] + cardPoints[i];
            minSlidSum = Math.min(minSlidSum, slidSum);
        }

        return totalSum - minSlidSum;
    }
}
