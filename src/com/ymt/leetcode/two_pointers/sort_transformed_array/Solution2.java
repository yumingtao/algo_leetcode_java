package com.ymt.leetcode.two_pointers.sort_transformed_array;

/**
 * @Description 双指针
 * @author yumingtao
 * @date 2022-02-06 20:37
 */
public class Solution2 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] ans = new int[n];
        if (a > 0) {
            int index = n - 1;
            //当a>0时，开口向上的抛物线，临界点前单调递减，临界点后单调递增
            while (left <= right) {
                //与临界点距离越远值越大
                int leftValue = fn(nums[left], a, b, c);
                int rightValue = fn(nums[right], a, b, c);
                if (leftValue >= rightValue) {
                    ans[index] = leftValue;
                    //谁大谁移动
                    ++left;
                } else {
                    ans[index] = rightValue;
                    //谁大谁移动
                    --right;
                }
                --index;
            }
        } else if (a < 0) {
            int index = 0;
            //当a<0时，开口向下的抛物线，临界点前当掉递增，临界点后单调递减
            while (left <= right) {
                //与临界点距离越远值越小
                int leftValue = fn(nums[left], a, b, c);
                int rightValue = fn(nums[right], a, b, c);
                if (leftValue <= rightValue) {
                    ans[index] = leftValue;
                    //谁小谁移动
                    ++left;
                } else {
                    ans[index] = rightValue;
                    //谁小谁移动
                    --right;
                }
                ++index;
            }
        } else {
            //当a=0时，取决于b
            if (b > 0) {
                //b>0时，单调递增
                //b=0时，直线，可以和b>0合并
                for (int i = 0; i < n; ++i) {
                    ans[i] = fn(nums[i], a, b, c);
                }
            } else {
                //b<0时，单调递减
                for (int i = 0; i < n; ++i) {
                    ans[n - i - 1] = fn(nums[i], a, b, c);
                }
            }
        }
        return ans;
    }

    private int fn(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
