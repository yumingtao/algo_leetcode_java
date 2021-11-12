package com.ymt.leetcode.double_pointer.remove_element;

/**
 * 思路:快慢指针
 *
 * @author yumingtao
 * @date 2021/11/12 16:37
 */
public class Solution1 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }
        return slow;
    }
}
