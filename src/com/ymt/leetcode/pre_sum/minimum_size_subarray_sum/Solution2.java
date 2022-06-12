package com.ymt.leetcode.pre_sum.minimum_size_subarray_sum;

/**
 * @author yumingtao
 * @date 2021/9/14 09:36
 */
public class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
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
        Solution2 solution = new Solution2();
        int ans = solution.minSubArrayLen(4, nums);
        System.out.println(ans);
    }
}


//7
//[2,3,1,2,4,3]
//4
//[1,4,4]
//11
//[1,1,1,1,1,1,1,1]