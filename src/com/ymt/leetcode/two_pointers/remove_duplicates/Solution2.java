package com.ymt.leetcode.two_pointers.remove_duplicates;

/**
 * @author yumingtao
 * @date 2021/11/15 09:51
 */
public class Solution2 {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }

        return j + 1;
    }
}
