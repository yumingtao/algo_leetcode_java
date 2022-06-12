package com.ymt.leetcode.two_pointers.max_consecutive_ones_ii;

/**
 * 思路：滑窗
 *
 * @author yumingtao
 * @date 2021/12/6 11:34
 */
public class Solution3 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zeroCount = 0;
        int left = 0;
        int right = 0;
        int len = nums.length;
        int maxLen = 0;
        while (right < len) {
            //zeroCount没有超过1，right一直向右
            while (right < len && zeroCount <= 1) {
                if (nums[right] == 0) {
                    ++zeroCount;
                }
                //如果zeroCount还满足条件，更新解
                if (zeroCount <= 1) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
                //继续向右
                ++right;
            }
            //如果right到了数组结尾，不管zeroCount是多少，没有更大的maxLen，直接返回
            if (right == len) {
                return maxLen;
            }

            //right没有到数组结尾，说明zeroCount>1,收缩left
            //先更新解,right-1-left+1，第一个while中已经覆盖到
            //maxLen = Math.max(maxLen, right - left);
            while (left < right && zeroCount > 1) {
                if(nums[left] == 0){
                    --zeroCount;
                }
                //保证left可以移动到第一个0的下一个位置
                ++left;
            }
        }
        return maxLen;
    }
}
