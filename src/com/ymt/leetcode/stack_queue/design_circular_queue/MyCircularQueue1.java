package com.ymt.leetcode.stack_queue.design_circular_queue;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 使用List实现
 * @author yumingtao
 * @date 2022-02-17 19:48
 */
public class MyCircularQueue1 {
    private int head;
    private int tail;
    private List<Integer> data;
    private int size;
    private int capacity;

    public MyCircularQueue1(int k) {
        this.head = -1;
        this.tail = -1;
        this.size = 0;
        this.capacity = k;
        this.data = Arrays.asList(new Integer[capacity]);
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            ++head;
            ++tail;
            data.set(tail, value);
            ++size;
            return true;
        }
        ++tail;
        ++size;
        tail %= capacity;
        data.set(tail, value);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        --size;
        if (isEmpty()) {
            head = -1;
            tail = -1;
            this.data = Arrays.asList(new Integer[capacity]);
        } else {
            ++head;
            head %= capacity;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data.get(head);
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data.get(tail);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
