package com.ymt.leetcode.recursion_divide_conquer.majority_element;

import java.util.Arrays;

/**
 * @Description 排序数组，返回nums.length/2向下取整
 * @author yumingtao
 * @date 2022-03-29 20:32
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
