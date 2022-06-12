package com.ymt.leetcode.map_set.two_sum;

import java.util.HashMap;

/**
 * @Description 使用HashMap
 * @author yumingtao
 * @date 2022-02-27 15:35
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        return new int[]{};
    }
}
