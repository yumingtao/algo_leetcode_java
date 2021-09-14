package com.ymt.leetcode.array.minimum_size_subarray_sum;

/**
 * @author yumingtao
 * @date 2021/9/14 09:36
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];

            int targetSum = sum[i] - target;
            /**
             * j<=i
             * sum[i]-sum[j-1]>=target
             * sum[j-1]<=sum[i]-target
             * 求小于i的sum中是否有值小于等于target-sum[i]
             * 注意j的下标从0开始;如果是从1开始就使用sum[j-1]
             * 注意此处是i-j，不是i-j+1
             */
            for (int j = 1; j < i; j++) {
                if (sum[j - 1] <= targetSum) {
                    ans = Math.min(ans, i - j);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 4};
        //int[] nums = {1, 2, 3, 4, 5};
        //int[] nums = {2, 3, 1, 2, 4, 3};
        //int[] nums = {1,1,1,1,1,1,1,1};
        Solution solution = new Solution();
        int ans = solution.minSubArrayLen(4, nums);
        System.out.println(ans);
    }
}


//7
// 0 1 2 3 4 5 6
//[2,3,1,2,4,3]
// 0 2 5 6 8 12 15
//4
//[1,4,4]
//11
//[1,1,1,1,1,1,1,1]
//0  1  2  3  4  5
//1, 2, 3, 4, 5
//0  1  3  6  10 15