package com.ymt.leetcode.two_pointers.sort_colors;

/**
 * @author yumingtao
 * @date 2021/11/18 10:52
 */
public class Solution2 {
    public void sortColors(int[] nums) {
        int len = nums.length;

        //[0,p0) 0
        //[p0, i) 1
        //(p2, len -1] 2
        int i = 0;
        int p0 = 0;
        int p2 = len - 1;
        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, p2);
                p2--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
