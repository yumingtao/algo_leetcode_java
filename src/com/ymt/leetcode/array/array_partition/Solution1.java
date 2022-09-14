package com.ymt.leetcode.array.array_partition;

import java.util.Arrays;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-14 15:10
 */
public class Solution1 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length / 2; ++i) {
            ans += nums[2 * i];
        }
        return ans;
    }
}
