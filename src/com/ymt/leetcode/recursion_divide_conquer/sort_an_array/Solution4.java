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

    private void quickSort1(int[] nums, int left, int right) {
        // 选取中轴元素
        // left<=mid<=right
        int mid = partition(nums, left, right);
        // 左边至少有两个元素才进行排序
        // lef==mid,[left, mid-1]区间有0个元素，不需要排序；
        // left==mid-1，区间[left,mid-1]只有一个元素nums[mid-1],也不需要排序
        if (left != mid && left != mid - 1) {
            quickSort(nums, left, mid - 1);
        }

        // 右边至少有两个元素才进行排序
        // right==mid，[mid+1,right]区间有0个元素，不需要排序
        // right==mid+1，区间[mid+1,right]区间有1个元素，不需要排序
        if (right != mid && right != mid + 1) {
            quickSort(nums, mid + 1, right);
        }
    }

    private void quickSort(int[] nums, int left, int right) {
        // 根据quickSort1中的分析，并结合left<=mid<=right,可以得出简化的递归终止条件
        if (left >= right) {
            return;
        }
        int mid = partition(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    /**
     * 三种方式分区
     * 1. 选择第一个数为基数
     * 2. 选择最后一个数为基数
     * 3. 随机选择区间的任意一个数为基数，效率最优
     */
    private int partition(int[] nums, int start, int end) {
        //取第一个数为基数
        int pivot = nums[start];
        //从第二个数开始分区
        int left = start + 1;
        // 右边界
        int right = end;
        // 从left开始，遇到比基数大的，交换到数组的最后，right向左移动，知道left和right相遇
        while (left < right) {
            while (left < right && nums[left] <= pivot) {
                ++left;
            }
            // 如果left!=right,说明nums[left]>pivot,交换left和right
            if (left != right) {
                swap(nums, left, right);
                --right;
            }
            // 交换完，继续从left开始判断
        }
        // 如果left和right相遇，判断pivot和nums[right]
        if (left == right && nums[right] > pivot) {
            --right;
        }

        // 如果right和start相等，则不需要交换，直接返回即可
        // 如果right和start不想等，则交换
        if (right != start) {
            swap(nums, start, right);
        }
        // 通过上边的一系列操作，right指向的时基数，基数左边的所有数据都小于基数，右边的数据都大于基数
        return right;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
