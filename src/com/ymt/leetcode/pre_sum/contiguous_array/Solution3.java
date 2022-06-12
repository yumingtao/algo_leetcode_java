package com.ymt.leetcode.pre_sum.contiguous_array;

import java.util.HashMap;
import java.util.Map;

/**
 * 没有经过优化的前缀和+map
 *
 * @author yumingtao
 * @date 2021/9/17 16:55
 */
public class Solution3 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        int[] preSum = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            if (map.containsKey(preSum[i])) {
                ans = Math.max(ans, i - map.get(preSum[i]));
            } else {
                map.put(preSum[i], i);
            }
        }

        return ans;
    }
}
