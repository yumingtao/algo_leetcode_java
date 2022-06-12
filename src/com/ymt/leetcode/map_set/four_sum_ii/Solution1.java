package com.ymt.leetcode.map_set.four_sum_ii;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 借助两数相加和三数相加，超时
 * @author yumingtao
 * @date 2022/3/8 09:06
 */
public class Solution1 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        for (int num : nums1) {
            ans += threeSumCount(nums2, nums3, nums4, -num);
        }
        return ans;
    }

    private int threeSumCount(int[] nums1, int[] nums2, int[] nums3, int target) {
        int count = 0;
        for (int num : nums1) {
            count += twoSumCount(nums2, nums3, target-num);
        }
        return count;
    }

    private int twoSumCount(int[] nums1, int[] nums2, int target) {
        Map<Integer, Integer> countMap = new HashMap<>();
        //统计第一个数组中数字出现的次数
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        //遍历第二个数组，统计第一个数组中等于target-nums1[i]的数字的数量
        int count = 0;
        for (int num : nums2) {
            count += countMap.getOrDefault(target - num, 0);
        }
        return count;
    }
}
