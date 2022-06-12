package com.ymt.leetcode.two_pointers.minimum_operations_to_reduce_x_to_zero;

/**
 * 思路:双指针
 * 1.每次从最左边或最右边获取元素，变换思维，取中间连续最长的元素，使得和是sum-x
 *
 * @author yumingtao
 * @date 2021/11/23 15:16
 */
public class Solution3 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum == x) {
            return n;
        } else if (sum < x) {
            return -1;
        }

        int target = sum - x;
        //使用双指针，由1<=nums[i]<=10^4可知，区间和是递增的
        int left = 0;
        int right = 0;
        long slideSum = 0;
        int maxSlideLen = Integer.MIN_VALUE;
        while (right < n && left <= right) {
            slideSum += nums[right];
            while (slideSum > target) {
                slideSum -= nums[left++];
            }

            if (slideSum == target) {
                maxSlideLen = Math.max(maxSlideLen, right - left + 1);
            }
            ++right;
        }

        return maxSlideLen == Integer.MIN_VALUE ? -1 : n - maxSlideLen;
    }
}
