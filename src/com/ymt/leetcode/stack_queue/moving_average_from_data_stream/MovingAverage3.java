package com.ymt.leetcode.stack_queue.moving_average_from_data_stream;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 使用双端队列
 * @author yumingtao
 * @date 2022-02-21 20:07
 */
public class MovingAverage3 {
    private int size;
    private Deque<Integer> deque;
    private int windowSum;
    private int count;
    public MovingAverage3(int size) {
        this.size = size;
        this.count = 0;
        this.deque = new LinkedList<>();
    }

    public double next(int val) {
        deque.add(val);
        int first = count > size ? deque.pollFirst().intValue() : 0;
        windowSum = windowSum - first + val;
        return windowSum * 1.0 / Math.min(size, count);
    }
}
