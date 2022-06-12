package com.ymt.leetcode.recursion_divide_conquer.sort_an_array;

import java.util.Random;

/**
 * @Description Geek模版
 * @author yumingtao
 * @date 2022-03-23 21:53
 */
public class Solution5 {
    private Random random = new Random();

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        //1. 递归终止条件
        if (left >= right) {
            return;
        }

        //2. 拆分
        //选择中轴元素
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot);
        quickSort(nums, pivot + 1, right);

        //注意和归并排序的区别，这里不需要做合并处理
    }

    private int partition(int[] nums, int left, int right) {
        //通过随机索引找到数组中的一个随机元素
        int randomIndex = left + random.nextInt(right - left + 1);
        // nums[left]<=pivotValue<=nums[right]
        int pivotValue = nums[randomIndex];

        //调配，使随机元素左边的元素都小于等于pivotValue，右边的元素都大于等于pivotValue
        while (left <= right) {
            //如果随机元素左边的值小于等于随机元素的值，left向右移动
            while (nums[left] < pivotValue) {
                ++left;
            }

            //如果随机元素右边的值大于等于随机元素的值，right向左移动
            while (nums[right] > pivotValue) {
                --right;
            }

            //如果left指向的元素大于随机元素的值，且right指向的元素小于随机元素的值，且left<right,交换left和right
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
