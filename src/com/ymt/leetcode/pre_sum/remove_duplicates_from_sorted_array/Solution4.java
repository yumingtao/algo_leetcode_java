package com.ymt.leetcode.pre_sum.remove_duplicates_from_sorted_array;

/**
 * @author yumingtao
 * @date 2021/11/3 15:11
 */
public class Solution4 {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[len] != nums[i]) {
                nums[++len] = nums[i];
            }
        }

        return len + 1;
    }
}
