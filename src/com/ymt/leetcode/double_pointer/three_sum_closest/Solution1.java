package com.ymt.leetcode.double_pointer.three_sum_closest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 思路：暴力解法，O(n^3)
 *
 * @author yumingtao
 * @date 2021/11/12 09:48
 */
public class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    map.put(Math.abs(sum - target), sum);
                }
            }
        }
        int minKey = Integer.MAX_VALUE;
        for (Integer key : map.keySet()) {
            minKey = Math.min(minKey, key);
        }
        return map.get(minKey);
    }
}
