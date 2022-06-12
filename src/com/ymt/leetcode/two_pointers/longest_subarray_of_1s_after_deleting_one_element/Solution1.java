package com.ymt.leetcode.two_pointers.longest_subarray_of_1s_after_deleting_one_element;

/**
 * 思路：滑窗+前缀和
 * 1.把0换成1，把1换成0，问题求解转换成"求区间和<=1的最长子数组长度"
 * 2.求解完成后减1(删除一个元素)
 *
 * @author yumingtao
 * @date 2021/12/15 13:27
 */
public class Solution1 {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int lSum = 0;
        int rSum = 0;
        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            rSum += 1 - nums[right];
            while (left <= right && rSum - lSum > 1) {
                lSum += 1 - nums[left];
                ++left;
            }
            maxLen = Math.max(maxLen, right - left - 1);
        }
        return maxLen - 1;
    }
}
