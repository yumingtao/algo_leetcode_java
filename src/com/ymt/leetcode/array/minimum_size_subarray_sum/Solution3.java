package com.ymt.leetcode.array.minimum_size_subarray_sum;

import java.util.Arrays;

/**
 * @author yumingtao
 * @date 2021/9/14 09:36
 */
public class Solution3 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        //区间和sum[j]-sum[i-1]>=target
        //sum[j]>=target+sum[i-1]
        for (int i = 1; i <= n; i++) {
            //二分查找s在前缀和数组中的位置
            int index = Arrays.binarySearch(sum, target + sum[i - 1]);
            //当找不到时，(-(insertion point) - 1)
            if (index < 0) {
                //-(insertion point) - 1 = index;
                //insertion point = -(index+1)
                index = -index - 1;
            }

            //如果index<=n，即在前缀和数组中找到了
            if (index <= n) {
                ans = Math.min(ans, index - i + 1);
            }

            //0  1  2  3  4  5
            //1, 2, 3, 4, 5
            //0  1  3  6  10 15
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        //int[] nums = {1, 4, 4};
        int[] nums = {1, 2, 3, 4, 5};
        //int[] nums = {2, 3, 1, 2, 4, 3};
        //int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        Solution3 solution = new Solution3();
        int ans = solution.minSubArrayLen(15, nums);
        System.out.println(ans);
    }
}
