package com.ymt.leetcode.two_pointers.sliding_window_maximum;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description Solution7简单优化
 * @author yumingtao
 * @date 2022-01-15 19:52
 */
public class Solution8 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
         1. 窗口中，i<j且nums[i]<nums[j],由于i先滑出窗口，那么窗口内的最大值永远不是nums[i],可以在队列中把i删除，需要弹出队尾的操作
         2. 窗口向右滑动过程中，队列头的下标可能已经滑出窗口左侧，需要不断出栈，直到下标满足窗口范围
         */
        //使用双端队列，队列存储存储数组的下标，从小到大
        Deque<Integer> deque = new LinkedList<>();
        //先初始k大小窗口
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        for (int i = 0; i < len; ++i) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
