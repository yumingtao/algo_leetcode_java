package com.ymt.leetcode.two_pointers.longest_continuous_subarray_with_absolute_diff_less_than_or_equal_to_limit;

import java.util.TreeMap;

/**
 * @Description 滑窗+TreeMap
 * @author yumingtao
 * @date 2022-01-22 13:59
 */
public class Solution1 {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int maxLen = 0;
        int left = 0;
        for (int right = 0; right < nums.length; ++right) {
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            while (left <= right && Math.abs(treeMap.firstKey() - treeMap.lastKey()) > limit) {
                int count = treeMap.get(nums[left]);
                --count;
                if (count == 0) {
                    treeMap.remove(nums[left]);
                } else {
                    treeMap.put(nums[left], count);
                }
                ++left;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
