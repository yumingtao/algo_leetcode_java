package com.ymt.leetcode.two_pointers.sliding_window_maximum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 思路：使用优先队列，超时
 *
 * @author yumingtao
 * @date 2022/1/14 09:49
 */
public class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //先将数组转成Node数组
        int len = nums.length;
        Node[] nodes = new Node[len];
        for (int i = 0; i < len; ++i) {
            nodes[i] = new Node(nums[i], i);
        }

        //java的堆是小根堆，需要提供比较器
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                //o1.value-o2.value是小根堆，反之是大根堆
                return o2.value - o1.value;
            }
        });
        //先初始k大小的滑动窗口
        for(int i = 0; i < k; ++i){
            queue.add(nodes[i]);
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(queue.peek().value);

        //向右滑动窗口
        for(int i = k; i < len; ++i){
            //删除左边界i-k对应的node
            queue.remove(nodes[k - i]);
            //添加右边界i对应的node
            queue.add(nodes[i]);
            //此时的左右边界为[k-i+1, i],判断top的index是否在该范围，如果不在，移除
            Node top = queue.peek();
            if(top.index < k - i + 1){
                queue.remove(top);
            }
            ans.add(queue.peek().value);
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
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
