package com.ymt.leetcode.recursion_divide_conquer.shu_zu_zhong_de_ni_xu_dui_lcof;

/**
 * @Description 归并排序，统计两个有序数组合并的过程中统计逆序对
 * @author yumingtao
 * @date 2022/3/22 10:49
 */
public class Solution3 {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        //1.递归终止条件
        if (left == right) {
            return 0;
        }

        //2.拆分
        int mid = (left + right) / 2;
        int leftCount = mergeSort(nums, left, mid);
        int rightCount = mergeSort(nums, mid + 1, right);

        //3.合并处理结果
        return leftCount + rightCount + mergeAndCountPairs(nums, left, mid, right);
    }

    private int mergeAndCountPairs(int[] nums, int left, int mid, int right) {
        //创建临时数组temp
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;
        int count = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                //nums[i]大于nums[j]及后边所有元素
                //站在j的角度，左半部分数组有mid-i+1个元素大于当前j的元素
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }

        return count;
    }
}
