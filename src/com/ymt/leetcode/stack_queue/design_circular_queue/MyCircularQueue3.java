package com.ymt.leetcode.stack_queue.design_circular_queue;

/**
 * @Description 参考题解
 * @author yumingtao
 * @date 2022-02-20 12:15
 */
public class MyCircularQueue3 {
    private int head;
    private int tail;
    private int[] data;
    private int size;

    public MyCircularQueue3(int k) {
        this.data = new int[k];
        this.head = -1;
        this.tail = -1;
        this.size = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            ++head;
        }
        ++tail;
        tail %= size;
        data[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            ++head;
            head %= size;
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
        return head == -1;
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }
}
