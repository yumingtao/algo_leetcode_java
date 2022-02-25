package com.ymt.leetcode.map_set.contains_duplicate_ii;

import java.util.HashMap;

/**
 * 思路：使用HashMap
 *
 * @author yumingtao
 * @date 2022/2/25 20:15
 */
public class Solution1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                //-k<=i-j<=k
                if (j >= i - k && j <= i + k) {
                    return true;
                }
            }
            //如不存在和nums[i]相等的数，添加到map
            //或存在和nums[i]相等的数，但不满足abs(i-j)<=k,则用最新的索引更新旧的索引
            map.put(nums[i], i);
        }
        return false;
    }
}
