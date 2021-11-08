package com.ymt.leetcode.pre_sum.longest_well_performing_interval;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和+Map
 *
 * @author yumingtao
 * @date 2021/10/3 23:15
 */
public class Solution2 {
    public int longestWPI(int[] hours) {
        Map<Integer, Integer> preSumIndex = new HashMap<>();
        int preSum = 0;
        int ans = 0;
        for (int i = 0; i < hours.length; i++) {
            //将数组的值和8比较，>8 -> 1, <8 -> -1
            int value = hours[i] > 8 ? 1 : -1;

            //求出数组前缀和
            preSum = preSum + value;

            if (preSum > 0) {
                //直接i+1更新ans
                ans = i + 1;
            } else {
                //去找是否存在x使得前缀和preSum[i]-preSum[x]>0

                //记录preSum小于0的最小的位置
                if (!preSumIndex.containsKey(preSum)) {
                    preSumIndex.put(preSum, i);
                }

                //获取preSum-1的索引，
                //preSum[i]-preSum[x]=1时，存在最大的区间满足preSum[i]-preSum[x]
                if (preSumIndex.containsKey(preSum - 1)) {
                    ans = Math.max(ans, i - preSumIndex.get(preSum - 1));
                }
            }
        }

        return ans;
    }
}
