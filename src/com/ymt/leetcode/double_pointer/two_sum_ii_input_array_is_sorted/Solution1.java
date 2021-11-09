package com.ymt.leetcode.double_pointer.two_sum_ii_input_array_is_sorted;

/**
 * 思路：暴力解法
 *
 * @author yumingtao
 * @date 2021/11/9 09:03
 */
public class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            //注意j < i
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{};
    }
}
