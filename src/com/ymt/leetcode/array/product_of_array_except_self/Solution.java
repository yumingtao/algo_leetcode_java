package com.ymt.leetcode.array.product_of_array_except_self;

/**
 * @author yumingtao
 * @date 2021/9/14 22:18
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        //对于数组中下标i的元素
        //i前边元素的乘积为前缀之积，i后边元素的乘积为后缀之积
        //所以除i以外元素的乘积，就是i元素的前缀之积*后缀之积
        //所以问题演变为，求每个元素的前缀之积，后缀之积

        int n = nums.length;
        int[] lProduct = new int[n];
        int[] rProduct = new int[n];
        lProduct[0] = 1;
        rProduct[n - 1] = 1;

        //求前缀之积
        for (int i = 1; i < n; i++) {
            lProduct[i] = lProduct[i - 1] * nums[i - 1];
        }

        //求后缀之积
        for (int i = n - 2; i >= 0; i--) {
            rProduct[i] = rProduct[i + 1] * nums[i + 1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = lProduct[i] * rProduct[i];
        }

        return ans;
    }
}
