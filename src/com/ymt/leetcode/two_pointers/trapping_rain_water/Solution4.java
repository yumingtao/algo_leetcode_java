package com.ymt.leetcode.two_pointers.trapping_rain_water;

import java.util.Stack;

/**
 * @Description 题解单调栈
 * @author yumingtao
 * @date 2022-02-03 10:45
 */
public class Solution4 {
    public int trap(int[] height) {
        //存储柱子的索引，当前柱子的高度小于栈顶高度，则入栈
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int current = 0;
        while (current < height.length) {
            //当前高度大于栈顶高度，则出栈，计算存水
            //其中current和新的栈顶做为两边的墙，出栈的柱子高度做为要减去的高度
            while (!stack.isEmpty() && height[current] >= height[stack.peek()]) {
                //弹出栈顶
                int top = stack.pop();
                if (stack.isEmpty()) {
                    //左侧找不到对应的墙，无法存水，跳出循环
                    break;
                }
                //找出current的高度和新的栈顶的高度的最小值
                int newTop = stack.peek();
                int hMin = Math.min(height[current], height[newTop]);
                //计算面，有效高度*两墙之间距离current-newTop-1
                ans += (hMin - height[top]) * (current - newTop - 1);
            }
            stack.push(current);
            ++current;
        }
        return ans;
    }
}
