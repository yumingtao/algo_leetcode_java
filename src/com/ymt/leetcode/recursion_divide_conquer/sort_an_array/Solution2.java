package com.ymt.leetcode.recursion_divide_conquer.sort_an_array;

/**
 * @Description Geek模版
 * @author yumingtao
 * @date 2022/3/15 17:37
 */
public class Solution2 {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        //1. 递归终止条件
        if (left == right) {
            return;
        }

        //2. 拆分
        int mid = (left + right) / 2;
        //左半部分
        mergeSort(nums, left, mid);
        //右半部分
        mergeSort(nums, mid + 1, right);

        //3. 合并
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        //[left, mid],[mid+1,right]两个部分已经分别排序好，合并两个有序的数组，使nums在区间[left,right]上有序
        //临时数组，存储nums区间[left,right]的数据
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        //将temp复制到nums的[left,right]
        for (int l = 0; l < temp.length; ++l) {
            nums[left + l] = temp[l];
        }
    }
}
