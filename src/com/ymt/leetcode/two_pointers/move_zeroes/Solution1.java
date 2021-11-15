package com.ymt.leetcode.two_pointers.move_zeroes;

/**
 * @author yumingtao
 * @date 2021/11/7 14:54
 */
public class Solution1 {
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
    }
}
