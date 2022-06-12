package com.ymt.leetcode.two_pointers.maximum_erasure_value;

import java.util.HashSet;
import java.util.Set;

/**
 * 思路: Solution1优化
 *
 * @author yumingtao
 * @date 2021/12/2 10:41
 */
public class Solution4 {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxSum = 0;
        Set<Integer> set = new HashSet<>();
        while (right < nums.length) {
            if (set.contains(nums[right])) {
                while (nums[left] != nums[right]) {
                    sum -= nums[left];
                    set.remove(nums[left]);
                    ++left;
                }
                //left移动到重复数字的后一个位置
                //因为重复的已经在set中添加过，并已经计算到sum中，所以直接进入下一次循环
                ++left;
            } else {
                set.add(nums[right]);
                sum += nums[right];
                maxSum = Math.max(maxSum, sum);
            }
            ++right;
        }

        return maxSum;
    }
}
