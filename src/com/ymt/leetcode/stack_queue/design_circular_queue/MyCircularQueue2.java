package com.ymt.leetcode.stack_queue.design_circular_queue;

/**
 * @Description 使用数组实现
 * @author yumingtao
 * @date 2022-02-20 11:33
 */
public class MyCircularQueue2 {
    private int head;
    private int tail;
    private int[] data;
    private int size;

    public MyCircularQueue2(int k) {
        this.data = new int[k];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            ++head;
        }
        ++tail;
        ++size;
        tail %= data.length;
        data[tail] = value;
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
        } else {
            ++head;
            head %= data.length;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}
