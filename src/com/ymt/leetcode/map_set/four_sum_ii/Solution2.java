package com.ymt.leetcode.map_set.four_sum_ii;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description Solution1优化
 * @author yumingtao
 * @date 2022/3/8 10:11
 */
public class Solution2 {
    private Map<Integer, Integer> nums4CountMap = new HashMap<>();
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //预处理，先统计最后一个数组中数字出现的次数
        for (int num : nums4) {
            nums4CountMap.put(num, nums4CountMap.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (int num : nums1) {
            ans += threeSumCount(nums2, nums3, nums4, -num);
        }
        return ans;
    }

    private int threeSumCount(int[] nums2, int[] nums3, int[] nums4, int target) {
        int count = 0;
        for (int num : nums2) {
            count += twoSumCount(nums3, target - num);
        }
        return count;
    }

    private int twoSumCount(int[] nums3, int target) {
        //遍历第二个数组，统计第一个数组中等于target-nums1[i]的数字的数量
        int count = 0;
        for (int num : nums3) {
            count += nums4CountMap.getOrDefault(target - num, 0);
        }
        return count;
    }
}
