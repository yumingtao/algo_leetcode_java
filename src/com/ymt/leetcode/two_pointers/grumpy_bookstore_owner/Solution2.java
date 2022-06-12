package com.ymt.leetcode.two_pointers.grumpy_bookstore_owner;

/**
 * 思路：原始满意度+最大窗口增量满意度+滑动窗
 *
 * @author yumingtao
 * @date 2021/11/22 14:35
 */
public class Solution2 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int originSatisfiedCount = 0;
        int increaseCount = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                originSatisfiedCount += customers[i];
            } else if (i < minutes) {
                increaseCount += customers[i];
            }
        }
        int maxIncreaseSatisfiedCount = increaseCount;
        for (int i = minutes; i < n; i++) {
            increaseCount += customers[i] * grumpy[i] - customers[i - minutes] * grumpy[i - minutes];
            maxIncreaseSatisfiedCount = Math.max(maxIncreaseSatisfiedCount, increaseCount);
        }

        return originSatisfiedCount + maxIncreaseSatisfiedCount;
    }
}
