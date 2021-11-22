package com.ymt.leetcode.two_pointers.grumpy_bookstore_owner;

/**
 * 思路：原始满意度+最大窗口增量满意度+前缀和
 *
 * @author yumingtao
 * @date 2021/11/22 09:45
 */
public class Solution1 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int originSatisfiedCount = 0;
        int maxIncreaseSatisfiedCount = 0;
        int[] increaseSatisfiedPSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                originSatisfiedCount += customers[i];
                increaseSatisfiedPSum[i + 1] = increaseSatisfiedPSum[i];
            } else {
                increaseSatisfiedPSum[i + 1] = increaseSatisfiedPSum[i] + customers[i];
            }
        }

        //left从0开始，区间和pSum[right+1]-pSum[left]
        //区间长度是minutes，则right-left+1=minutes->right=left+minutes-1
        //right+1<=n -> left+minutes<=n ->left <= n-minutes+1
        //令i表示left
        for (int i = 0; i <= n - minutes; i++) {
            maxIncreaseSatisfiedCount = Math.max(maxIncreaseSatisfiedCount,
                    increaseSatisfiedPSum[i + minutes] - increaseSatisfiedPSum[i]);
        }

        return originSatisfiedCount + maxIncreaseSatisfiedCount;
    }
}
