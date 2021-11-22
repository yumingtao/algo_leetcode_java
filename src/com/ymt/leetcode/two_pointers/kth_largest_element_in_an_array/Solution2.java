package com.ymt.leetcode.two_pointers.kth_largest_element_in_an_array;

/**
 * 思路:快速排序，选出pivot，然后通过两个指针相向，将数组按照pivot分成两个区域
 *
 * @author yumingtao
 * @date 2021/11/19 17:20
 */
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;
        while (true) {
            int pIndex = partition(nums, left, right);
            if (pIndex == target) {
                return nums[pIndex];
            } else if (pIndex < target) {
                left = pIndex + 1;
            } else {
                right = pIndex - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        //其主体思想还是找到一个随机的索引，并将该值放到left
        //然后对剩下的元素进行分区，大于索引值的在
        int randomIndex = left + (int) Math.random() * (right - left + 1);
        //[left...le] <= pivot
        //(le...ge)
        //[ge, right] >= pivot
        //int pivot = nums[randomIndex];
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        //双指针分别控制小于等于或大于等于pivot的索引位置，用于元素交换，达到分区的目的
        int le = left + 1;
        int ge = right;

        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }

            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }

            if(le > ge){
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }

        swap(nums, left, ge);
        return ge;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
