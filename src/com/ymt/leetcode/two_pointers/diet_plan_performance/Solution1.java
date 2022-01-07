package com.ymt.leetcode.two_pointers.diet_plan_performance;

/**
 * 思路：
 * 1. k长度的固定滑窗，统计滑窗内数字之和
 * 2. 判断滑窗内数字之和与lower和upper之间的关系
 *
 * @author yumingtao
 * @date 2022/1/7 10:26
 */
public class Solution1 {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int slideSum = 0;
        int ans = 0;
        for(int i = 0; i < k; ++i){
            slideSum += calories[i];
        }
        ans += evaluate(slideSum, lower, upper);
        int left = 0;
        for (int right = k; right < calories.length; ++right){
            slideSum += calories[right] - calories[left];
            ans += evaluate(slideSum, lower, upper);
            ++left;
        }
        return ans;
    }

    private int evaluate(int sum, int lower, int upper){
        if(sum < lower){
            return -1;
        }else if(sum > upper){
            return 1;
        }
        return 0;
    }
}
