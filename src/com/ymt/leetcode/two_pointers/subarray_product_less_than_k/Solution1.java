package com.ymt.leetcode.two_pointers.subarray_product_less_than_k;

/**
 * @Description 滑窗+计数
 * @author yumingtao
 * @date 2022-01-09 21:13
 */
public class Solution1 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return getCount(nums, k);
    }

    private int getCount(int[] nums, int max) {
        int product = 1;
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < nums.length) {
            product *= nums[right];
            while (left <= right && product >= max) {
                product /= nums[left];
                ++left;
            }
            ans += right - left + 1;
            ++right;
        }
        return ans;
    }
}
