package com.ymt.leetcode.two_pointers.sort_colors;

/**
 * 思路:双指针，分别处理0和2
 *
 * @author yumingtao
 * @date 2021/11/18 15:03
 */
public class Solution7 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p2 = n - 1;
        for (int i = 0; i < n; i++) {
            //交换
            if (nums[i] == 0) {
                swap(nums, i, p0++);
            } else if (nums[i] == 2) {
                swap(nums, i, p2--);
                //此时不知道i的位置是什么值，如果是1则不需要处理，否则继续处理0或1的情况
                if(nums[i] != 1){
                    --i;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
