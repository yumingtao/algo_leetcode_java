package com.ymt.leetcode.recursion_divide_conquer.sort_an_array;

import java.util.Random;

/**
 * @Description 快速排序
 * @author yumingtao
 * @date 2022/3/16 10:53
 */
public class Solution3 {
    private Random random = new Random();
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right){
        //1. 递归终止条件
        if(left >= right){
            return;
        }

        //2. 拆分
        //选择中轴元素
        int pivot = partition(nums, left, right);
        // 注意左侧包含了中轴元素
        quickSort(nums, left, pivot);
        quickSort(nums, pivot + 1, right);

        //注意和归并排序的区别，这里不需要做合并处理
    }

    private int partition(int[] nums, int left, int right){
        //通过随机索引找到数组中的一个随机元素
        int randomIndex = left + random.nextInt(right - left + 1);
        // nums[left]<=pivotValue<=nums[right]
        int pivotValue = nums[randomIndex];

        //调配，使随机元素左边的元素都小于等于pivotValue，右边的元素都大于等于pivotValue
        while(left <= right){
            //如果随机元素左边的值小于等于随机元素的值，left向右移动
            while (nums[left] < pivotValue){
                ++left;
            }

            //如果随机元素右边的值大于等于随机元素的值，right向左移动
            while (nums[right] > pivotValue){
                --right;
            }

            // 如果相遇，说明都已经满足左边小于中轴元素，右边大于中轴元素，直接退出循环，放回right即可
            if(left == right){
                break;
            }

            //如果left指向的元素大于随机元素的值，且right指向的元素小于随机元素的值，且left<right,交换left和right
            if(left < right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                ++left;
                --right;
            }
        }
        // 来到这里有两种情况
        // 1. left==right相遇，已经满足左边小于中轴元素，右边大于中轴元素
        // 2. left>right,因为nums[left]<=pivotValue<=nums[right], 那么两个指针left和right一定会有一个指针会和pivotValue相等，
        //    不管时哪种情况，最终right指向的都是中轴元素
        // 所以此处返回的始终是right,因为在分区的时候在左侧包含了pivot中轴元素，如果是在右侧包含中轴元素，返回的就是left
        return right;
    }
}
