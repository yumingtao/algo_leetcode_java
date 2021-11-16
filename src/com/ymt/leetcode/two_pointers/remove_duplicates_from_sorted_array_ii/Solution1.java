package com.ymt.leetcode.two_pointers.remove_duplicates_from_sorted_array_ii;

/**
 * @author yumingtao
 * @date 2021/11/16 09:38
 */
public class Solution1 {
    public int removeDuplicates(int[] nums) {
        return remove(nums, 2);
    }

    private int remove(int[] nums, int k) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (i < k || (i >= k && nums[i - k] != nums[j])) {
                nums[i++] = nums[j];
            }
        }

        return i;
    }
}
