package com.ymt.leetcode.two_pointers.sliding_window_median;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description 参考官方题解
 * @author yumingtao
 * @date 2022-01-15 20:23
 */
public class Solution1 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        DuaHeap duaHeap = new DuaHeap(k);
        int len = nums.length;
        double[] ans = new double[len - k + 1];
        //先处理第一个滑窗
        for (int i = 0; i < k; ++i) {
            duaHeap.insert(nums[i]);
        }
        ans[0] = duaHeap.getMedian();
        //处理向右移动滑窗
        for (int i = k; i < len; ++i) {
            //i-k滑出，需要移除
            duaHeap.remove(nums[i - k]);
            //i滑入，需要插入
            duaHeap.insert(nums[i]);
            ans[i - k + 1] = duaHeap.getMedian();
        }
        return ans;
    }

    class DuaHeap {
        //大根堆，存储滑窗较小的前半段，取k/2向下取整个数，如果k是奇数，个数会比large多一个数
        //注意：num可能是边界值，如果使用 o2.intValue() - o1.intValue()的方式会超出int范围，造成结果与实际结果相反
        //private PriorityQueue<Integer> small = new PriorityQueue<>((o1, o2) -> o2.intValue() - o1.intValue());
        private PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());
        //大根堆，存储滑窗较大的后半段
        private PriorityQueue<Integer> large = new PriorityQueue<>();
        //队中需要延时删除的数字，key：数字，value：延时删除次数
        private Map<Integer, Integer> delayed = new HashMap<>();
        //small中元素的格式
        private int smallSize;
        //large中元素的个数
        private int largeSize;
        private int k;

        public DuaHeap(int k) {
            this.k = k;
        }

        public void insert(int num) {
            if (small.isEmpty() || num <= small.peek()) {
                //如果插入的数字比small的top小，则存入small
                small.offer(num);
                ++smallSize;
            } else {
                //存入large
                large.offer(num);
                ++largeSize;
            }
            //重新平衡small和large中元素的个数
            balance();
        }

        /*
        延时删除，如果是栈顶的元素，则真正删除，否则只做标记，之后延时删除
         */
        public void remove(int num) {
            delayed.put(num, delayed.getOrDefault(num, 0) + 1);
            int smallTop = small.peek();
            if(num <= smallTop){
                //如果num在small中，更新smallSize
                --smallSize;
                //判断是否需要真正删除
                if(num == smallTop){
                    prune(small);
                }
            }else {
                //如果num出现在large
                --largeSize;
                //判断是否需要真正删除
                if(num == large.peek()){
                    prune(large);
                }
            }
            //删除完之后，small和large中的元素个数有可能发生变化，需要重新平衡
            balance();
        }

        public double getMedian() {
            //如果k是奇数，返回中间的数，刚好是small的top；如果k是偶数，返回small的top和large的top的平均数
            //注意相加的时候可能会越界，需要先转成double
            return (k & 1) == 1 ? small.peek() / 1.0 : ((double) small.peek() + large.peek()) / 2.0;
        }

        private void balance() {
            if (smallSize - largeSize == 2){
                large.offer(small.poll());
                --smallSize;
                ++largeSize;
                //small有了新的top，需要判断是否真正删除top
                prune(small);
            }
            if (largeSize - smallSize == 1){
                small.offer(large.poll());
                ++smallSize;
                --largeSize;
                //large有了新的top，判断是否需要真正删除top
                prune(large);
            }
        }

        /*
         不断的弹出top，并更新delayed
         */
        private void prune(PriorityQueue<Integer> heap){
            while (!heap.isEmpty()){
                int num = heap.peek();
                if(delayed.containsKey(num)){
                    int count = delayed.get(num);
                    --count;
                    if(count == 0){
                        delayed.remove(num);
                    }else {
                        delayed.put(num, count);
                    }
                    heap.poll();
                }else {
                    break;
                }
            }
        }
    }
}
