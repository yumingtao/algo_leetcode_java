package com.ymt.leetcode.two_pointers.two_sum_less_than_k;

import java.util.Arrays;

/**
 * @Description 排序+对撞指针
 * @author yumingtao
 * @date 2022-01-26 20:39
 */
public class Solution2 {
    public int twoSumLessThanK(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int maxSum = -1;
        int sum = 0;
        //首先升序排序数组
        Arrays.sort(nums);
        while (left < right) {
            sum = nums[left] + nums[right];
            while (left < right && sum < k) {
                //当和小于k时，更新最大值
                maxSum = Math.max(maxSum, sum);
                //移动小的一端，尝试更大的值是否满足
                ++left;
                sum = nums[left] + nums[right];
            }
            /*
            //没必要判断
            if(left == right){
                break;
            }*/
            //当和大于k时，可能是right太大，尝试小一点的right
            --right;
        }
        return maxSum;
    }
}
