package com.ymt.leetcode.two_pointers.remove_element;

/**
 * 思路：对撞指针
 *
 * @author yumingtao
 * @date 2021/11/12 16:43
 */
public class Solution2 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            }else {
                left++;
            }
        }

        return left;
    }
}
