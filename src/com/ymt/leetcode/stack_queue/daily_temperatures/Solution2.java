package com.ymt.leetcode.stack_queue.daily_temperatures;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 题解：单调栈
 * @author yumingtao
 * @date 2022-02-22 22:39
 */
public class Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; ++i) {
            //如果当前温度大于栈顶温度，那么该温度一定是栈中所有小于它的右侧的临界值（大于某个值的最小值），出栈并更新解
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            //如果小于栈顶元素就压入栈
            stack.push(i);
        }
        return ans;
    }
}
