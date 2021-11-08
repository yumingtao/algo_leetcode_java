package com.ymt.leetcode.pre_sum.continuous_subarray_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用前缀和+map
 *
 * @author yumingtao
 * @date 2021/9/17 11:17
 */
public class Solution2 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for (int i = 1; i <= n; i++) {
            //先求出数组的前缀和
            sum[i] = sum[i - 1] + nums[i - 1];

            int mod = sum[i] % k;

            //判断count中是否存在sum[i] % k
            if (map.containsKey(mod)) {
                int index = map.get(mod);
                if (i - index >= 2) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }

        return false;
    }
}
