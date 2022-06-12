package com.ymt.leetcode.stack_queue.moving_average_from_data_stream;

/**
 * @Description 题解：使用基于数组的循环队列
 * @author yumingtao
 * @date 2022-02-21 21:10
 */
public class MovingAverage4 {
    private int head;
    private int[] data;
    private int size;
    private double windowSum;
    private int count;

    public MovingAverage4(int size) {
        this.head = 0;
        this.size = size;
        this.data = new int[size];
        this.windowSum = 0;
        this.count = 0;
    }

    public double next(int val) {
        ++count;
        //先得到尾元素索引
        int tail = (head + 1) % size;
        windowSum = windowSum - data[tail] + val;
        //head向前移动一个位置，因为是循环队列，主要要取模
        head = (head + 1) % size;
        data[head] = val;
        return windowSum * 1.0 / Math.min(size, count);
    }
}
