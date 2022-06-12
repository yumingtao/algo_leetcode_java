package com.ymt.leetcode.two_pointers.trapping_rain_water;

/**
 * @Description 双指针
 * @author yumingtao
 * @date 2022-02-02 23:46
 */
public class Solution2 {
    public int trap(int[] height) {
        int len = height.length;
        int left = 0;
        //leftMax表示当前left下标左边的最大高度，不一定是紧挨着left位置的
        int leftMax = height[0];
        int right = len - 1;
        //rightMax是当前right下标右边最大的高度，不一定是紧挨着right位置的
        int rightMax = height[left - 1];
        int ans = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                //只要leftMax<rightMax,leftMax是受信任的，无论rightMax是多少，后边的rightMax只会大于等于当前的rightMax
                //而当前位置的存水量只与短板有关
                ans += leftMax - height[left];
                ++left;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                //如果rightMax>=leftMax，rightMax是受信任的
                ans += rightMax - height[right];
                --right;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return ans;
    }
}
