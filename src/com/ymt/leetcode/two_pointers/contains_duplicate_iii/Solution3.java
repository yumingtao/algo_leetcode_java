package com.ymt.leetcode.two_pointers.contains_duplicate_iii;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 题解：利用桶
 * @author yumingtao
 * @date 2022-01-18 21:31
 */
public class Solution3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> map = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long id = getId(nums[i], w);
            //落在一个桶里，直接返回
            if (map.containsKey(id)) {
                return true;
            }
            //再看相邻的两个桶
            if (map.containsKey(id - 1) && Math.abs(map.get(id - 1) - nums[i]) <= t) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(map.get(id + 1) - nums[i]) <= t) {
                return true;
            }
            map.put(id, (long) nums[i]);
            //移除滑出窗口的num
            if (i >= k) {
                map.remove(getId(nums[i - k], w));
            }
        }
        return false;
    }

    private long getId(long num, long w) {
        if (num >= 0) {
            return num / w;
        }
        //负数的绝对值从1开始，所以+1才能保证绝对值从0开始，然后再-1
        //最终保证负数落到正确的区间，如w=10,-1 ... -10应该是1个区间，如果不这样处理就落到两个区间
        return (num + 1) / w - 1;
    }
}
