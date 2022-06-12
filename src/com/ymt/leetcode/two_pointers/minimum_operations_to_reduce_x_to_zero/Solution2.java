package com.ymt.leetcode.two_pointers.minimum_operations_to_reduce_x_to_zero;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路: Map+前缀和+优化
 * 1.每次从最左边或最右边获取元素，变换思维，取中间连续最长的元素，使得和是sum-x
 *
 * @author yumingtao
 * @date 2021/11/23 15:07
 */
public class Solution2 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }
        if (sum == x) {
            return n;
        }

        long target = sum - x;
        long pSum = 0;
        Map<Long, Integer> targetMap = new HashMap<>();
        targetMap.put(0L, 0);
        //0=<j<i,区间和pSum[i+1]-pSum[j]=target -> pSum[j]=pSum[i+1]-target
        //pSum[i]-pSum[j-1]=target -> pSum[j-1]=pSum[i]-target
        int maxTargetOperations = Integer.MIN_VALUE;
        for (int i = 1; i <= n; ++i) {
            pSum += nums[i - 1];
            long key = pSum - target;
            //只存储最老的i
            if (!targetMap.containsKey(pSum)) {
                targetMap.put(pSum, i);
            }
            if (targetMap.containsKey(key)) {
                int len = i - targetMap.get(key);
                if (len >= 0) {
                    maxTargetOperations = Math.max(maxTargetOperations, i - targetMap.get(key));
                }
            }
        }
        return maxTargetOperations == Integer.MIN_VALUE ? -1 : n - maxTargetOperations;
    }
}
