package com.ymt.leetcode.recursion_divide_conquer.majority_element;

import java.util.Random;

/**
 * @Description 利用快速排序
 * @author yumingtao
 * @date 2022-03-29 21:00
 */
public class Solution2 {
    private final Random random = new Random();

    public int majorityElement(int[] nums) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n / 2);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        //递归终止条件
        if (left >= right) {
            return nums[k];
        }
        //获取中轴元素下标
        int pivot = partion(nums, left, right);
        if (pivot >= k) {
            return quickSelect(nums, left, pivot, k);
        } else {
            return quickSelect(nums, pivot + 1, right, k);
        }
    }

    private int partion(int[] nums, int left, int right) {
        // 获取随机下标
        int randomIndex = left + random.nextInt(right - left + 1);
        int pivotValue = nums[randomIndex];

        // 调配元素，使小于中轴元素的在pivotValue的左边，大于中轴元素在pivotValue右边
        while (left <= right) {
            while (nums[left] < pivotValue) {
                ++left;
            }

            while (nums[right] > pivotValue) {
                --right;
            }

            if (left <= right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                ++left;
                --right;
            }
        }
        return right;
    }
}
