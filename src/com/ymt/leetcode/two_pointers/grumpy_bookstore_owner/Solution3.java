package com.ymt.leetcode.two_pointers.grumpy_bookstore_owner;

/**
 * @Description 滑窗
 * @author yumingtao
 * @date 2021-12-28 19:38
 */
public class Solution3 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int len = customers.length;
        //先假设没有这连续x分钟不生气的技巧，正常算出有多少客户能够满意
        int normalSum = 0;
        for (int i = 0; i < len; ++i) {
            normalSum += customers[i] * (1 - grumpy[i]);
        }

        //滑动窗口找出连续x分钟的最大客流量差额
        int maxExtraCustomers = 0;
        int extraCustomers = 0;
        int start = 0;
        int end = 0;
        while (end < len) {
            if (end == 0) {
                while (end < minutes) {
                    extraCustomers += customers[end] * grumpy[end];
                    ++end;
                }
                --end;
            } else {
                extraCustomers += customers[end] * grumpy[end];
            }

            maxExtraCustomers = Math.max(maxExtraCustomers, extraCustomers);
            extraCustomers -= customers[start] * grumpy[start];
            ++start;
            ++end;
        }

        return normalSum + maxExtraCustomers;
    }
}
