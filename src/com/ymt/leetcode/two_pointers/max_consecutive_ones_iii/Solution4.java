package com.ymt.leetcode.two_pointers.max_consecutive_ones_iii;

/**
 * 思路：滑动窗口+前缀和变化
 * 1. 将0转换成1，将1转换成0，变相求区间和<=k的最大区间长度
 * 2. rSum-lSum<=k
 *
 * @author yumingtao
 * @date 2021/12/15 10:08
 */
public class Solution4 {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int lSum = 0;
        int rSum = 0;
        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            rSum += 1 - nums[right];
            while (left <= right && rSum - lSum > k) {
                lSum += 1 - nums[left];
                ++left;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
