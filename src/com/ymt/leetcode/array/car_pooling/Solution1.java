package com.ymt.leetcode.array.car_pooling;

/**
 * 使用差分
 * 1.先计算差分数组
 * 2.求差分数组的前缀和得到原数组
 * 3.判断原数组在任意i是否存在大于capacity的值
 *
 * @author yumingtao
 * @date 2021/10/2 22:37
 */
public class Solution1 {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;

        //求出最远的结束位置
        int maxEnd = 0;
        for (int i = 0; i < n; i++) {
            maxEnd = Math.max(maxEnd, trips[i][2]);
        }

        //循环trips，计算差分数组
        int[] delta = new int[maxEnd + 2];
        for (int i = 0; i < n; i++) {
            int l = trips[i][1];
            int r = trips[i][2];
            int value = trips[i][0];
            delta[l] += value;
            delta[r] -= value;
        }

        //对差分数组求前缀和，得到原数组
        int[] deltaSum = new int[maxEnd + 1];
        for (int i = 1; i <= maxEnd; i++) {
            deltaSum[i] = deltaSum[i - 1] + delta[i - 1];
        }

        //循环deltaSum数组，如果有值大于capacity则返回false，否则true
        for (int i = 1; i <= maxEnd; i++) {
            if (deltaSum[i] > capacity) {
                return false;
            }
        }

        return true;
    }
}
