package com.ymt.leetcode.array.product_of_array_except_self;

/**
 * @author yumingtao
 * @date 2021/9/14 22:18
 */
public class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        //对于数组中下标i的元素
        //i前边元素的乘积为前缀之积，i后边元素的乘积为后缀之积
        //所以除i以外元素的乘积，就是i元素的前缀之积*后缀之积
        //所以问题演变为，求每个元素的前缀之积，后缀之积

        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;

        //求前缀之积，直接使用ans数组，不重新定义lProduct数组
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        //求后缀之积的同时，将前缀积和后缀积相乘的结果赋值给ans数组
        int rProduct = 1;

        //2  3   4  5
        //60 20  5  1
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= rProduct;
            rProduct *= nums[i];
        }

        return ans;
    }
}
