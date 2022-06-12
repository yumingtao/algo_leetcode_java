package com.ymt.leetcode.recursion_divide_conquer.reverse_pairs;

/**
 * @Description 利用归并排序和双指针
 * @author yumingtao
 * @date 2022-04-04 17:39
 */
public class Solution1 {
    private int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int left, int right) {
        //递归终止条件
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        mergeAndCount(nums, left, mid, right);
    }

    private void mergeAndCount(int[] nums, int left, int mid, int right) {
        count(nums, left, mid, right);
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int p = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[p++] = nums[i++];
            } else {
                temp[p++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[p++] = nums[i++];
        }

        while (j <= right) {
            temp[p++] = nums[j++];
        }

        for (int k = 0; k < temp.length; ++k) {
            nums[left + k] = temp[k];
        }
    }

    private void count(int[] nums, int left, int mid, int right) {
        int j = mid + 1;
        for (int i = left; i <= mid; ++i) {
            while (j <= right && nums[i] > 2l * nums[j]) {
                ++j;
            }
            //j-1-(mid+1)+1
            count += j - mid - 1;
        }
    }
}
