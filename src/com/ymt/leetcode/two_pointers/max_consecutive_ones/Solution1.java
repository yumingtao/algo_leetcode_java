package com.ymt.leetcode.two_pointers.max_consecutive_ones;

/**
 * 思路：滑窗
 *
 * @author yumingtao
 * @date 2021/12/6 13:48
 */
public class Solution1 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int right = 0;
        int maxLen = 0;
        for (int left = 0; left < len; left++) {
            //先找到不为0的left
            if (nums[left] == 0) {
                continue;
            }
            //right指向left的后一个位置，如果不为0就继续向右移动
            right = left + 1;
            while (right < len && nums[right] != 0) {
                ++right;
            }
            //更新解,right-1-left+1 ->right-left
            maxLen = Math.max(maxLen, right - left);
            //继续下一个left
            ++left;
        }

        return maxLen;
    }
}