package com.ymt.leetcode.two_pointers.sort_transformed_array;

/**
 * @Description Solution2合并分支
 * @author yumingtao
 * @date 2022-02-06 21:41
 */
public class Solution3 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] ans = new int[n];
        if (a >= 0) {
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
        }
        return ans;
    }

    private int fn(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
