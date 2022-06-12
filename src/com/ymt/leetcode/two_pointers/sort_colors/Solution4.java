package com.ymt.leetcode.two_pointers.sort_colors;

/**
 * 思路：两次遍历
 * 1.第一次遍历，把0移动到最左端
 * 2.第二次遍历，把1移动到0后边
 *
 * @author yumingtao
 * @date 2021/11/18 12:38
 */
public class Solution4 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                swap(nums, i, p++);
            }
        }

        for (int i = p; i < n; i++) {
            if (nums[i] == 1) {
                swap(nums, i, p++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
