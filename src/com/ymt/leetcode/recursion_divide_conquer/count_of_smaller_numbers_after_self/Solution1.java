package com.ymt.leetcode.recursion_divide_conquer.count_of_smaller_numbers_after_self;

import java.util.*;

/**
 * @Description 利用快速排序
 * @author yumingtao
 * @date 2022-04-02 11:45
 */
public class Solution1 {
    private Map<Integer, Integer> countMap = new HashMap<>();
    private int[] index;

    public List<Integer> countSmaller(int[] nums) {
        //存储元素的索引，在merge的过程中涉及到有序数组的合并，元素的顺序会发生变化
        index = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            index[i] = i;
            countMap.put(i, 0);
        }
        mergeSort(nums, 0, nums.length - 1);
        List<Integer> ans = new ArrayList<>();
        for (int key = 0; key < nums.length; ++key) {
            ans.add(countMap.get(key));
        }
        return ans;
    }

    private void mergeSort(int[] nums, int left, int right) {
        //递归终止条件
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        mergeCount(nums, left, mid, right);
    }

    private void mergeCount(int[] nums, int left, int mid, int right) {
        int n = right - left + 1;
        //临时数组保存排序好的[left,right]区间的数据
        int[] temp = new int[n];
        //临时数组保存排序好的[left,right]区间的数据的索引
        int[] tempIndex = new int[n];
        int i = left;
        int j = mid + 1;
        int p = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[p] = nums[i];
                tempIndex[p] = index[i];
                //[mid+1,j)的元素个数为j-1-(mid+1)+1 -> j-mid-1
                countMap.put(index[i], countMap.get(index[i]) + j - mid - 1);
                ++i;
                ++p;
            } else {
                temp[p] = nums[j];
                tempIndex[p++] = index[j++];
            }
        }

        while (i <= mid) {
            temp[p] = nums[i];
            tempIndex[p] = index[i];
            //[mid+1,right]元素的个数为right-(mid+1)+1 -> right-mid, 也可以是j-1-mid，因为此时j=right+1
            countMap.put(index[i], countMap.get(index[i]) + right - mid);
            ++i;
            ++p;
        }
        while (j <= right) {
            temp[p] = nums[j];
            tempIndex[p++] = index[j++];
        }
        for (int k = 0; k < n; ++k) {
            nums[left + k] = temp[k];
            index[left + k] = tempIndex[k];
        }
    }
}
