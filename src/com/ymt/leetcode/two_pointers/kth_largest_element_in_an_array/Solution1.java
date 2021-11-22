package com.ymt.leetcode.two_pointers.kth_largest_element_in_an_array;

/**
 * 思路: 快速排序确定切分元素的思想 - 将<=切分元素的数组放到一侧
 * 1.定义切分元素pivot=nums[left],将pivot的索引与target=len-k比较
 * 2.在[left+1, right],重新寻找pivot，定义指针p，初始指向left，寻找结束后，[left+1,p]<=新pivot，(p,right]>pivot
 * 3.在2的过程中，将切分元素先放到了left的位置，然后将[left+1, right]的元素分区
 *
 * @author yumingtao
 * @date 2021/11/19 10:28
 */
public class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        //第k大，就是第len-k小
        int target = len - k;
        int left = 0;
        int right = len - 1;
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
        //先随机一个随机索引，范围(left, right),Math.random()的范围是[0.0,1.0)
        //randomIndex [left, right)，目的是通过一轮遍历之后，
        //randomIndex之前数<=nums[randomIndex],randomIndex之前数>nums[randomIndex]
        int randomIndex = left + (int) Math.random() * (right - left + 1);
        //交换randomIndex和left，然后将pivot设置到left，即切分元素设置为随机索引对应的数组元素
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        //指针p初始指向left，p指向<=pivot的最后一个数组元素的位置
        //此处相当于使用了单个指针
        int p = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                p++;
                swap(nums, i, p);
            }
        }

        //经过遍历，p来到了=pivot的位置,因为nums[randomIndex]>=nums[left]
        //将randomIndex对应的值和p对应的值交换
        //最终达到randomIndex之前数<=nums[randomIndex],randomIndex之前数>nums[randomIndex]
        swap(nums, p, randomIndex);
        return p;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

