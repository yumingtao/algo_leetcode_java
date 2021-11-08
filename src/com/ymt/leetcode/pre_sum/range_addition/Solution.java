package com.ymt.leetcode.pre_sum.range_addition;

/**
 * 使用差分
 *
 * @author yumingtao
 * @date 2021/9/15 14:33
 */
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        //使用差分，更新值的时候，l位置+d，r+1位置-d
        //区间范围0～n+1
        //定义差分数组
        int[] delta = new int[length + 2];

        for (int i = 0; i < updates.length; i++) {
            delta[updates[i][0]] += updates[i][2];
            delta[updates[i][1] + 1] -= updates[i][2];
        }

        //差分数组前缀和就是原数组
        int[] ans = new int[length];
        int sum = 0;

        for (int i = 1; i <= length; i++) {
            sum += delta[i - 1];
            ans[i - 1] = sum;
        }

        return ans;
    }
}