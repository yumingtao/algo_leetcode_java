package com.ymt.leetcode.two_pointers.remove_duplicates_from_sorted_array;

/**
 * @author yumingtao
 * @date 2021/11/16 10:31
 */
public class Solution6 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (i == 0 || (i >= 1 && nums[i - 1] != nums[j])) {
                nums[i++] = nums[j];
            }
        }

        return i;
    }
}
