package com.ymt.leetcode.two_pointers.longest_subarray_of_1s_after_deleting_one_element;

/**
 * 思路：经典滑窗
 *
 * @author yumingtao
 * @date 2021/12/23 17:26
 */
public class solution6 {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int maxLen = 0;
        int count = 0;
        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] == 0) {
                ++count;
            }

            while (count > 1) {
                if (nums[left++] == 0) {
                    --count;
                }
            }
            //本来长度应该是right-left+1，但是要删除掉一个元素，所以次数编程right-left+1-1 -> right-left
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}