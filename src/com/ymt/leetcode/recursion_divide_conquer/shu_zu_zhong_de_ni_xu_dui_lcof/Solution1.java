package com.ymt.leetcode.recursion_divide_conquer.shu_zu_zhong_de_ni_xu_dui_lcof;

/**
 * @Description 归并排序，统计两个拍好序的数组中的逆序对，直接使用两个for会超时，优化了之后偶尔勉强通过
 * @author yumingtao
 * @date 2022/3/17 16:14
 */
public class Solution1 {
    private int count = 0;
    public int reversePairs(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int left, int right) {
        //1. 递归终止条件
        if(left == right){
            return;
        }

        //2. 拆分
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums,mid + 1, right);

        //3. 合并，处理结果
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right){
        //计算pairs
        for(int i = left; i <= mid; ++i){
            int j = mid + 1;
            while (j <= right && nums[i] > nums[j]){
                ++j;
            }

            if(j <= right){
                count += j - mid - 1;
            }else {
                count += right - mid;
            }
        }
        //数组在[left, mid],[mid+1, right]分别是排序好的
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        while(i <= mid){
            temp[k++] = nums[i++];
        }

        while(j <= right){
            temp[k++] = nums[j++];
        }

        for(int p = 0; p < temp.length; ++p){
            nums[left + p] = temp[p];
        }
    }
}
