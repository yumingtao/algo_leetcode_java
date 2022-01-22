package com.ymt.leetcode.two_pointers.longest_continuous_subarray_with_absolute_diff_less_than_or_equal_to_limit;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 参考题解：使用滑窗+单调队列
 * @author yumingtao
 * @date 2022-01-22 14:01
 */
public class Solution2 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();
        int maxLen = 0;
        int left = 0;
        for (int right = 0; right < nums.length; ++right) {
            while (!minQ.isEmpty() && minQ.peekLast() > nums[right]) {
                minQ.pollLast();
            }
            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[right]) {
                maxQ.pollLast();
            }
            minQ.addLast(nums[right]);
            maxQ.addLast(nums[right]);
            while (!minQ.isEmpty() && !maxQ.isEmpty() && maxQ.getFirst() - minQ.getFirst() > limit) {
                if (nums[left] == minQ.getFirst()) {
                    minQ.pollFirst();
                }
                if (nums[left] == maxQ.getFirst()) {
                    maxQ.pollFirst();
                }
                ++left;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
