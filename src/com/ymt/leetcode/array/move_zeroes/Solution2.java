package com.ymt.leetcode.array.move_zeroes;

/**
 * @author yumingtao
 * @date 2021/11/7 15:31
 */
public class Solution2 {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        //将不是0的元素都移动到左边
        int j = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[j++] = num;
            }
        }

        //从j开始，剩余元素设置为0
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}
