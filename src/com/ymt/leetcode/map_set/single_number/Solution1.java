package com.ymt.leetcode.map_set.single_number;

import java.util.Arrays;

/**
 * @Description 使用排序
 * @author yumingtao
 * @date 2022-02-26 15:50
 */
public class Solution1 {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < n; i += 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[n - 1];
    }
}
