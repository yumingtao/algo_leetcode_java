package com.ymt.leetcode.two_pointers.sort_colors;

/**
 * 思路：两次遍历
 * 1.第一次遍历，将0移动到最左边，同时统计1的数量
 * 2.第二次遍历
 *
 * @author yumingtao
 * @date 2021/11/18 15:17
 */
public class Solution8 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                nums[p++] = 0;
            }
            if (nums[i] == 1) {
                ++count;
            }
        }

        for (int i = p; i < n; i++) {
            if (count > 0) {
                nums[p++] = 1;
                --count;
            }
            nums[p++] = 2;
        }
    }
}
