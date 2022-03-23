package com.ymt.leetcode.recursion_divide_conquer.kth_largest_element_in_an_array;

import java.util.Random;

/**
 * @Description
 * @author yumingtao
 * @date 2022/3/22 15:15
 */
public class Solution1 {
    private final Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        //对于排序后的数组，第k大，即是第nums.length-k小
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        //1. 递归终止条件
        if (left == right) {
            //说明所在分区部分的元素都已经排好序，直接返回第k小的元素即可
            return nums[k];
        }

        //2.计算中轴，拆分
        int pivot = partition(nums, left, right);
        if (pivot >= k) {
            //说明第k小的元素还在[left,pivot]区间
            return quickSelect(nums, left, pivot, k);
        } else {
            //说明第k小的元素还在[pivot+1,right]区间
            return quickSelect(nums, pivot + 1, right, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        //计算随机元素
        int randomIndex = left + random.nextInt(right - left + 1);
        int pivotValue = nums[randomIndex];

        while (left <= right) {
            //排序，大于pivotValue的元素放在其右边，小于pivotValue的放在其左边
            while (nums[left] < pivotValue) {
                ++left;
            }

            while (nums[right] > pivotValue) {
                --right;
            }

            if (left == right) {
                break;
            }

            if (left < right) {
                //nums[left]>pivotValue,nums[right]<pivotValue,交换nums[left]和nums[right]
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
