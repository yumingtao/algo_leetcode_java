package com.ymt.leetcode.two_pointers.longest_subarray_of_1s_after_deleting_one_element;

/**
 * 思路:统计滑动窗口內数字出现的频率(次数)
 *
 * @author yumingtao
 * @date 2021/12/15 15:44
 */
public class Solution3 {
    public int longestSubarray(int[] nums) {
        int[] counts = new int[2];
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < nums.length) {
            ++counts[nums[right]];
            //收缩left
            while (left <= right && counts[0] > 1) {
                --counts[nums[left]];
                ++left;
            }
            //left移动到使counts[0]<=1的位置
            maxLen = Math.max(maxLen, right - left + 1);
            ++right;
        }
        return maxLen - 1;
    }
}
