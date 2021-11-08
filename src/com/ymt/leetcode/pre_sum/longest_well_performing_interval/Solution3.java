package com.ymt.leetcode.pre_sum.longest_well_performing_interval;

import java.util.Stack;

/**
 * 前缀和+单调递减栈
 *
 * @author yumingtao
 * @date 2021/10/3 23:45
 */
public class Solution3 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] preSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            //将数组的值和8比较，>8 -> 1, <8 -> -1
            int value = hours[i - 1] > 8 ? 1 : -1;

            //求出数组前缀和
            preSum[i] = preSum[i - 1] + value;
        }

        //递减栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            if (!stack.isEmpty() && preSum[stack.peek()] <= preSum[i]) {
                continue;
            }
            stack.push(i);
        }

        //倒序遍历preSum
        int ans = 0;
        for (int i = n; i >= 0; i--) {
            if (preSum[i] - preSum[stack.peek()] > 0) {
                ans = Math.max(ans, i - stack.peek());
                stack.pop();
                i++;

                if (stack.isEmpty()) {
                    break;
                }
            }
        }

        return ans;
    }
}
