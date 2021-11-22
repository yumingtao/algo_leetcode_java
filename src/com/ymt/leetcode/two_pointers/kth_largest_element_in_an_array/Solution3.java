package com.ymt.leetcode.two_pointers.kth_largest_element_in_an_array;

/**
 * 思路：快速排序选择pivot，判断pivot是否和target相等
 *
 * @author yumingtao
 * @date 2021/11/19 17:30
 */
public class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return quickSelect(nums, len - k, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int left, int right) {
        if (left >= right) {
            return nums[k];
        }
        int pIndex = partition(nums, left, right);
        if (k <= pIndex) {
            //注意此时要包含p
            return quickSelect(nums, k, left, pIndex);
        } else {
            return quickSelect(nums, k, pIndex + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + (int) Math.random() * (right - left + 1);
        int pivot = nums[randomIndex];
        while (left <= right) {
            while (nums[left] < pivot) {
                left++;
            }

            while (nums[right] > pivot) {
                right--;
            }

            if (left == right) {
                break;
            }

            if (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        return right;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
