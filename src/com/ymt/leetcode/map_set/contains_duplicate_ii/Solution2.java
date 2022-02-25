package com.ymt.leetcode.map_set.contains_duplicate_ii;

import java.util.HashSet;

/**
 * 思路：使用滑动窗口
 * 1. 枚举滑动窗口，判断每个滑动窗口内是否有重复元素
 *
 * @author yumingtao
 * @date 2022/2/25 20:29
 */
public class Solution2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            //i-k-1移出滑动窗口
            if (i - k - 1 >= 0) {
                set.remove(nums[i - k -1]);
            }
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
