package com.ymt.leetcode.two_pointers.maximum_erasure_value;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：滑窗+固定left
 *
 * @author yumingtao
 * @date 2021/12/2 10:16
 */
public class Solution2 {
    public int maximumUniqueSubarray(int[] nums) {
        int len = nums.length;
        int right = 0;
        int maxSum = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int left = 0; left < len; left++){
            while(right < len && !map.containsKey(nums[right])){
                sum += nums[right];
                map.put(nums[right], right);
                ++right;
            }
            maxSum = Math.max(maxSum, sum);
            sum -= nums[left];
            map.remove(nums[left]);
        }

        return maxSum;
    }
}
