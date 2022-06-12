package com.ymt.leetcode.two_pointers.sliding_window_maximum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description Solution3优化
 * @author yumingtao
 * @date 2022-01-15 16:41
 */
public class Solution4 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //先将数组转成Node数组
        int len = nums.length;
        //java的堆是小根堆，需要提供比较器
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            //o1.value-o2.value是小根堆，反之是大根堆
            return o2.value - o1.value;
        });
        //先初始k大小的滑动窗口
        for (int i = 0; i < k; ++i) {
            queue.add(new Node(nums[i], i));
        }
        //结果数组的大小是len-k+1
        int[] ans = new int[len - k + 1];
        ans[0] = queue.peek().value;
        //向右滑动窗口
        for (int i = k; i < len; ++i) {
            //添加右边界i对应的node
            queue.add(new Node(nums[i], i));
            //此时的左右边界为[i-k+1, i],判断top的index是否在该范围，如果不在，移除
            while (queue.peek().index < i - k + 1) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek().value;
        }
        return ans;
    }

    class Node {
        private int value;
        private int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
