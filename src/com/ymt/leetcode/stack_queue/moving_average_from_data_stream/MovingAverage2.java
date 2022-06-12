package com.ymt.leetcode.stack_queue.moving_average_from_data_stream;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description 参考题解:使用List
 * @author yumingtao
 * @date 2022-02-21 19:55
 */
public class MovingAverage2 {
    private int size;
    private List<Integer> queue;
    public MovingAverage2(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        queue.add(val);
        double windowSum = 0;
        int start = Math.max(0, queue.size() - size);
        for (int i = start; i < queue.size(); ++i){
            windowSum += queue.get(i).intValue();
        }
        return windowSum * 1.0 / Math.min(size, queue.size());
    }
}
