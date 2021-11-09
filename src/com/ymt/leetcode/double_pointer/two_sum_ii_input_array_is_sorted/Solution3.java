package com.ymt.leetcode.double_pointer.two_sum_ii_input_array_is_sorted;

/**
 * 思路: 使用二分查找
 *
 * @author yumingtao
 * @date 2021/11/9 11:37
 */
public class Solution3 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        //通过for循环，先固定一端i
        for (int i = 0; i < n; i++) {
            //需要在i之后的数中找到是否存在target-numbers[i]
            int value = target - numbers[i];
            int res = binarySearch(numbers, i + 1, value);
            if (res != -1) {
                return new int[]{i + 1, res + 1};
            }
        }

        return new int[]{};
    }

    private int binarySearch(int[] numbers, int start, int target) {
        int left = start;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                //解可能还在左边
                right = mid - 1;
            } else {
                //解一定不在左边，可能在右边
                left = mid + 1;
            }
        }

        return -1;
    }
}
