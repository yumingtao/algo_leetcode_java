package com.ymt.leetcode.recursion_divide_conquer.sort_an_array;

import java.util.Random;

/**
 * @Description 使用快速排序
 * @author yumingtao
 * @date 2022/3/23 10:53
 */
public class Solution4 {
    private final Random random = new Random();
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        // 选取中轴元素
        // left<=mid<=right
        int mid = partition(nums, left, right);
        // 左边至少有两个元素才进行排序
        // lef==mid,[left, mid-1]区间有0个元素，不需要排序；
        // left==mid-1，区间[left,mid-1]只有一个元素nums[mid-1],也不需要排序
        if(left != mid && left != mid - 1){
            quickSort(nums, left, mid - 1);
        }

        // 右边至少有两个元素才进行排序
        // right==mid，[mid+1,right]区间有0个元素，不需要排序
        // right==mid+1，区间[mid+1,right]区间有1个元素，不需要排序
        if(right != mid && right != mid + 1){
            quickSort(nums, mid + 1, right);
        }
    }

    /**
     * 三种方式分区
     * 1. 选择第一个数为基数
     * 2. 选择最后一个数为基数
     * 3. 随机选择区间的任意一个数为基数，效率最优
     */
    private int partition(int[] nums, int start, int end) {

    }
}
