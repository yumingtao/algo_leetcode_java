package com.ymt.leetcode.two_pointers.sort_colors;

/**
 * 思路：Solution4重构
 * 1.第一次遍历，把0移动到最左端
 * 2.第二次遍历，把1移动到0后边
 *
 * @author yumingtao
 * @date 2021/11/18 12:29
 */
public class Solution5 {
    public void sortColors(int[] nums) {
        int p = moveElement(nums, 0, 0);
        moveElement(nums, p, 1);
    }

    private int moveElement(int[] nums, int start, int target){
        int p = start;
        for(int i = p; i < nums.length; i++){
            if(nums[i] == target){
                swap(nums, i, p++);
            }
        }

        return p;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
