package com.ymt.leetcode.pre_sum.continuous_subarray_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和+map+空间优化
 *
 * @author yumingtao
 * @date 2021/9/17 11:18
 */
public class Solution3 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for (int i = 1; i <= n; i++) {
            //先求出数组的前缀和
            sum = sum + nums[i - 1];
            int mod = sum % k;
            //判断count中是否存在sum[i] % k
            if (map.containsKey(mod)) {
                if (i - map.get(mod) >= 2) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }

        return false;
    }
}
