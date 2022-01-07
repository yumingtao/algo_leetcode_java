package com.ymt.leetcode.two_pointers.diet_plan_performance;

/**
 * 思路：Solution1优化
 *
 * @author yumingtao
 * @date 2022/1/7 11:27
 */
public class Solution2 {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int slideSum = 0;
        int ans = 0;
        for(int i = 0; i < k; ++i){
            slideSum += calories[i];
        }
        if(slideSum < lower){
            --ans;
        }else if(slideSum > upper){
            ++ans;
        }
        int left = 0;
        for (int right = k; right < calories.length; ++right){
            slideSum += calories[right] - calories[left];
            if(slideSum < lower){
                --ans;
            }else if(slideSum > upper){
                ++ans;
            }
            ++left;
        }
        return ans;
    }
}
