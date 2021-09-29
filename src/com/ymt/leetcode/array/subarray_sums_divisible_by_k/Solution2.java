package com.ymt.leetcode.array.subarray_sums_divisible_by_k;

/**
 * @author yumingtao
 * @date 2021/9/30 01:06
 */
public class Solution2 {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[k];
        count[0] = 1;

        int ans = 0;
        int preSum = 0;
        for (int i = 1; i <= n; i++) {
            preSum += nums[i - 1];

            // 注意当被除数为负数时取模结果为负数，需要纠正
            int key = (preSum % k + k) % k;
            ans += count[key];
            count[key]++;
        }

        return ans;
    }
}
