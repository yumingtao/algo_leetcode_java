package com.ymt.leetcode.two_pointers.remove_duplicates;

/**
 * @author yumingtao
 * @date 2021/11/15 09:45
 */
public class Solution1 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast++];
            }
            fast++;
        }

        return slow + 1;
    }
}
