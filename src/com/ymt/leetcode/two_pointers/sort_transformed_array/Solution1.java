package com.ymt.leetcode.two_pointers.sort_transformed_array;

import java.util.Arrays;

/**
 * @Description 暴力解法
 * @author yumingtao
 * @date 2022-02-06 20:37
 */
public class Solution1 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = a * nums[i] * nums[i] + b * nums[i] + c;
        }
        Arrays.sort(ans);
        return ans;
    }
}
