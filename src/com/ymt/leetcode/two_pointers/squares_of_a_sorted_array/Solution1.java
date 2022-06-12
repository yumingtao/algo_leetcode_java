package com.ymt.leetcode.two_pointers.squares_of_a_sorted_array;

/**
 * 思路：双指针
 * 1. x的二次方曲线，开口向上，距离最低点越远值越大
 * 2. left指向数组头，right指向数组尾，从后往前填充结果数组
 * 2.1 如果nums[left]的平方值大，将平方值填充到结果数组，并向右移动left
 * 2.2 如果nums[right]的平方值大，将平方值填充到结果数组，并向左移动right
 *
 * @author yumingtao
 * @date 2022/2/9 13:37
 */
public class Solution1 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] ans = new int[n];
        int index = n - 1;
        while (left <= right) {
            int leftValue = nums[left] * nums[left];
            int rightValue = nums[right] * nums[right];
            //比较x^2的值，谁大谁移动
            if (leftValue <= rightValue) {
                ans[index--] = rightValue;
                --right;
            } else {
                ans[index--] = leftValue;
                ++left;
            }
        }
        return ans;
    }
}
