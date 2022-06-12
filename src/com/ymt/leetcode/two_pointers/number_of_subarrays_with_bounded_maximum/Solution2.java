package com.ymt.leetcode.two_pointers.number_of_subarrays_with_bounded_maximum;

/**
 * @Description 滑窗+前缀和思想
 * 1. 小于等于right的子数组的个数-小于等于left-1的子数组的个数
 * 2. 滑窗找到小于max的最长子数组，并统计子数组的个数
 * 3. 假设数组的长度为n，可以组合的有效子数组的个数为n*(n+1)/2，就是1+2+3...+n
 *
 * 注意：不能通过n*(n+1)/2计算，会超出整数范围
 *
 * @author yumingtao
 * @date 2022-01-09 16:52
 */
public class Solution2 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return getCount(nums, right) - getCount(nums, left);
    }

    private int getCount(int[] nums, int max) {
        int left = 0;
        int right = 0;
        int ans = 0;
        //先找到左指针的为位置
        while (left < nums.length) {
            int count = 0;
            while (right < nums.length && nums[right] <= max) {
                ++right;
                ++count;
                ans += count;
            }
            left = right + 1;
            ++right;
        }
        return ans;
    }
}
