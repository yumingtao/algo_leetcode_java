package com.ymt.leetcode.recursion_divide_conquer.shu_zu_zhong_de_ni_xu_dui_lcof;

/**
 * @Description 归并排序，在合并两个有序数组的时候统计逆序对
 * @author yumingtao
 * @date 2022/3/18 11:15
 */
public class Solution2 {
    private int count = 0;

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int left, int right) {
        //1. 递归终止条件
        if (left == right) {
            return;
        }

        //2. 拆分
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        //3. 合并，处理结果
        mergeAndCountPairs(nums, left, mid, right);
    }

    private void mergeAndCountPairs(int[] nums, int left, int mid, int right) {
        //数组在[left, mid],[mid+1, right]分别是排序好的
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                //找到i和j，满足nums[i]>nums[j],由于两个分段数组都是升序的，所以i及i之后的数字都会和j组成逆序对，累积到count
                count += mid - i + 1;
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (int p = 0; p < temp.length; ++p) {
            nums[left + p] = temp[p];
        }
    }
}
