package com.ymt.leetcode.two_pointers.three_sum_smaller;

import java.util.Arrays;

/**
 * @Description 双指针
 * @author yumingtao
 * @date 2022-02-03 16:53
 */
public class Solution1 {
    public int threeSumSmaller(int[] nums, int target) {
        //首先升序排序数组
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target - nums[i]) {
                    //满足条件，更新ans
                    ans += right - left;
                    //left继续向右移动，尝试更大的值
                    ++left;
                } else {
                    //如果>=target-nums[i],由于数组是递增的，right向左移动，尝试较小的值是否满足
                    --right;
                }
            }
        }
        return ans;
    }
}