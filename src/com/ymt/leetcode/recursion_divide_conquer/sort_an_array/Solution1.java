package com.ymt.leetcode.recursion_divide_conquer.sort_an_array;

/**
 * @Description 合并排序
 * @author yumingtao
 * @date 2022/3/15 16:39
 */
public class Solution1 {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }

    private void  mergeSort(int[] nums, int left, int right, int[] temp){
        //1.递归终止条件
        if(left == right){
            return;
        }

        //2.拆分
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);

        //3.合并两个有序数组
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }

    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp){
        //[left, mid]部分的数组是有序的，[mid+1, right]部分的数组是有序的
        //先将nums复制到临时数组temp
        for(int i = left; i < right; ++i){
            temp[i] = nums[i];
        }

        int k = left;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right){
            //注意这里的=号是为了保持稳定性，原来相同的元素靠前的依然靠前
            if(temp[i] <= temp[j]){
                nums[k] = temp[i];
                ++k;
                ++i;
            }else {
                nums[k] = temp[j];
                ++k;
                ++j;
            }
        }

        while (i <= mid){
            nums[k] = temp[i];
            ++k;
            ++i;
        }

        while (j <= right){
            nums[k] = temp[j];
            ++k;
            ++j;
        }
    }
}
