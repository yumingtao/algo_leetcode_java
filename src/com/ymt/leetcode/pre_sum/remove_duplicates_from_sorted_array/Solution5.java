package com.ymt.leetcode.pre_sum.remove_duplicates_from_sorted_array;

/**
 * @author yumingtao
 * @date 2021/11/3 15:12
 */
public class Solution5 {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[len++] = nums[i];
            }
        }

        return len;
    }
}
