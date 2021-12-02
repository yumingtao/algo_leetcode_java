package com.ymt.leetcode.two_pointers.maximum_erasure_value;

import java.util.HashSet;
import java.util.Set;

/**
 * 思路：滑窗+Set
 *
 * @author yumingtao
 * @date 2021/12/2 10:34
 */
public class Solution3 {
    public int maximumUniqueSubarray(int[] nums) {
        int len = nums.length;
        int right = 0;
        int sum = 0;
        int maxSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int left = 0; left < len; left++) {
            while (right < len && !set.contains(nums[right])) {
                sum += nums[right];
                set.add(nums[right]);
                ++right;
            }
            maxSum = Math.max(maxSum, sum);
            sum -= nums[left];
            set.remove(nums[left]);
        }
        return maxSum;
    }
}
