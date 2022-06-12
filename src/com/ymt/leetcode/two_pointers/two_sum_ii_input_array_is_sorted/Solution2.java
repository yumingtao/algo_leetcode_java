package com.ymt.leetcode.two_pointers.two_sum_ii_input_array_is_sorted;

/**
 * 思路：双指针夹逼
 *
 * @author yumingtao
 * @date 2021/11/9 09:44
 */
public class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        //采用双指针夹逼
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            //numbers递增
            if (numbers[i] + numbers[j] > target) {
                //之和大于target，保持i不变，j向左移动
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                //之和小于target，j没必要再移动，将i向右移动
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }

        return new int[]{};
    }
}
