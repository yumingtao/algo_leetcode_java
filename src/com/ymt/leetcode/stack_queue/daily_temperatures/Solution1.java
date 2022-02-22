package com.ymt.leetcode.stack_queue.daily_temperatures;

import java.util.Arrays;

/**
 * @Description 题解：暴力的理解
 * @author yumingtao
 * @date 2022-02-22 20:25
 */
public class Solution1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        int[] nextHigh = new int[101];
        Arrays.fill(nextHigh, Integer.MAX_VALUE);
        for (int i = len - 1; i >= 0; --i) {
            //找出比当前温度temperatures[i]高的温度的最小下标, 比当前温度高的温度是temperatures[i]+1，最高温度是100
            int nextHighIndex = Integer.MAX_VALUE;
            for (int t = temperatures[i] + 1; t <= 100; ++t) {
                //遍历找出温度高于当前温度temperatures[i]，但是下标最小值
                if (nextHigh[t] < nextHighIndex) {
                    nextHighIndex = nextHigh[t];
                }
            }
            if (nextHighIndex < Integer.MAX_VALUE) {
                //如果找到了高于当前温度temperatures[i]的最小下标，更新解
                ans[i] = nextHighIndex - i;
            }
            //更新当前温度temperatures[i]的最小下标，因为是倒序遍历，所以i一定是当前温度的最小下标
            nextHigh[temperatures[i]] = i;
        }
        return ans;
    }
}
