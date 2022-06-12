package com.ymt.leetcode.two_pointers.maximum_erasure_value;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路:滑窗
 *
 * @author yumingtao
 * @date 2021/12/2 09:07
 */
public class Solution1 {
    public int maximumUniqueSubarray(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < len) {
            if (map.containsKey(nums[right])) {
                int lastRightIndex = map.get(nums[right]);
                while (left <= lastRightIndex) {
                    //sum中减去不用的left对应的数
                    sum -= nums[left];
                    //map中移除不用的left对应的数
                    map.remove(nums[left]);
                    //走到循环最后一次，left会到lastRightIndex+1的位置，循环外不用再处理
                    ++left;
                }
            }
            sum += nums[right];
            maxSum = Math.max(maxSum, sum);
            //更新map
            map.put(nums[right], right);
            ++right;
        }
        return maxSum;
    }
}
