package com.ymt.leetcode.two_pointers.trapping_rain_water;

/**
 * @Description 动态规划
 * 两次遍历，分别找到i左右高度的最大值，然后在左右高度最大值中取最小值与当前i的高度做差，最后累加
 * @author yumingtao
 * @date 2022-01-26 22:26
 */
public class Solution1 {
    public int trap(int[] height) {
        int len = height.length;
        //从左往右遍历，找到每个i的高度和它左侧的最大高度中的最大高度
        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < len; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        //从右往左遍历，找到每个i的高度和它右侧的最大高度中的最大高度
        int[] rightMax = new int[len];
        rightMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        //遍历leftMax和rightMax,i位置所接的雨水量min(leftMax[i],right[i])-height[i]
        int ans = 0;
        for (int i = 0; i < len; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
