package com.ymt.leetcode.two_pointers.max_consecutive_ones_iii;

/**
 * 思路:滑动窗口
 *
 * @author yumingtao
 * @date 2021/12/10 16:13
 */
public class Solution1 {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int zeroCount = 0;
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < len) {
            //right向右一直到0的个数大于k
            while (right < len && zeroCount <= k) {
                if (nums[right] == 0) {
                    ++zeroCount;
                }
                if (zeroCount <= k) {
                    //更新maxLen
                    maxLen = Math.max(maxLen, right - left + 1);
                }
                ++right;
            }
            //如果right先走到末尾，直接返回maxLen
            if (right == maxLen) {
                return maxLen;
            }
            //right没有走到末尾，zeroCont>k,收缩left，直到zeroCount<=k,收缩过程中不需要更新maxLen
            while (left <= right && zeroCount > k) {
                if (nums[left] == 0) {
                    --zeroCount;
                }
                ++left;
            }
        }
        return maxLen;
    }
}
