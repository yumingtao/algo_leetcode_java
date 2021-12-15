package com.ymt.leetcode.two_pointers.max_consecutive_ones_iii;

/**
 * 思路: 滑动窗口
 *
 * @author yumingtao
 * @date 2021/12/13 10:16
 */
public class Solution2 {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int maxLen = 0;
        while (right < len) {
            if (nums[right] == 0) {
                if (zeroCount < k) {
                    ++zeroCount;
                    maxLen = Math.max(maxLen, right - left + 1);
                } else {
                    //zeroCount=k，此时如果再加1就超过k
                    ++zeroCount;
                    //right-1-left+1
                    maxLen = Math.max(maxLen, right - left);
                    //收缩left
                    while (left <= right && zeroCount > k) {
                        if (nums[left] == 0) {
                            --zeroCount;
                        }
                        ++left;
                        //最终left会移动到使zeroCount<=k成立的某个0后边的一个位置
                    }
                }
            } else {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            ++right;
        }
        return maxLen;
    }
}
