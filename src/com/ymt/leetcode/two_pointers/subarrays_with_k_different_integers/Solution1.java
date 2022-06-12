package com.ymt.leetcode.two_pointers.subarrays_with_k_different_integers;

/**
 * @Description 参考题解
 * @author yumingtao
 * @date 2022-01-09 18:15
 */
public class Solution1 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return getCount(nums, k) - getCount(nums, k - 1);
    }

    private int getCount(int[] nums, int max) {
        int len = nums.length;
        int[] numCounts = new int[len + 1];
        int count = 0;
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < len) {
            if (numCounts[nums[right]] == 0) {
                ++count;
            }
            ++numCounts[nums[right]];

            while (count > max) {
                --numCounts[nums[left]];
                if (numCounts[nums[left]] == 0) {
                    --count;
                }
                ++left;
            }
            ans += right - left + 1;
            ++right;
        }
        return ans;
    }
}
