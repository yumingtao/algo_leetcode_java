package com.ymt.leetcode.two_pointers.remove_duplicates_from_sorted_array;

/**
 * @author yumingtao
 * @date 2021/11/3 14:45
 */
public class Solution2 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int fast = 1;
        int slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }

        return slow;
    }
}
