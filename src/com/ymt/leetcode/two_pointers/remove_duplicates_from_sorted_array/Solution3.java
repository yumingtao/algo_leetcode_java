package com.ymt.leetcode.two_pointers.remove_duplicates_from_sorted_array;

/**
 * 思路：
 * 本质上和官方题解没有区别
 *
 * @author yumingtao
 * @date 2021/11/3 14:48
 */
public class Solution3 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int curP = 0;
        int nextP = 1;
        while (nextP < n) {
            if (nums[curP] != nums[nextP]) {
                nums[++curP] = nums[nextP];
            }
            nextP++;
        }

        //因为curP代表指向最后一个元素的索引，所以长度要+1
        return curP + 1;
    }
}
