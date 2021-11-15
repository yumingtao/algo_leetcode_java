package com.ymt.leetcode.two_pointers.two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：使用map
 *
 * @author yumingtao
 * @date 2021/11/10 11:16
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(key, i);
            }
        }

        return new int[]{};
    }
}
