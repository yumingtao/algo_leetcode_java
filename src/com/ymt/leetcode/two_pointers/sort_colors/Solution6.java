package com.ymt.leetcode.two_pointers.sort_colors;

/**
 * 思路:双指针，分别处理0和1
 *
 * @author yumingtao
 * @date 2021/11/18 14:44
 */
public class Solution6 {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            //交换
            if (nums[i] == 0) {
                swap(nums, i, p0++);
                if (p0 < p1) {
                    //如果p0<p1,那么p0位置一定是1
                    //在第一次交换完成后，i的位置是1，需要再将i和p1交换
                    swap(nums, i, p1);
                }
                p1++;
            } else if (nums[i] == 1) {
                swap(nums, i, p1++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
