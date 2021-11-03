package com.ymt.leetcode.array.remove_duplicates_from_sorted_array;

/**
 * 双指针
 *
 * @author yumingtao
 * @date 2021/11/3 10:56
 */
public class Solution1 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int curP = 0;
        int nextP = 1;
        int len = 1;
        while (nextP < n) {
            if (nums[curP] != nums[nextP]) {
                nums[++curP] = nums[nextP];
                len++;
            }
            nextP++;
        }

        return len;
    }
}
