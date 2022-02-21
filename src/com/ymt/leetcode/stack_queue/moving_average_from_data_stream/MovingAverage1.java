package com.ymt.leetcode.stack_queue.moving_average_from_data_stream;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 使用队列
 * @author yumingtao
 * @date 2022-02-20 16:13
 */
public class MovingAverage1 {
    private int size;
    private int sum;
    private Queue<Integer> queue;

    public MovingAverage1(int size) {
        this.size = size;
        this.sum = 0;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        if (queue.size() >= size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum * 1.0 / queue.size();
    }
}
