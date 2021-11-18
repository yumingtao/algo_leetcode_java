package com.ymt.leetcode.two_pointers.sort_colors;

/**
 * 思路:计数数组，多次循环
 *
 * @author yumingtao
 * @date 2021/11/18 11:16
 */
public class Solution3 {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int j = 0;
        for (int i = 0; i < 3; i++) {
            int k = count[i];
            while (k > 0) {
                nums[j++] = i;
                k--;
            }
        }
    }
}
