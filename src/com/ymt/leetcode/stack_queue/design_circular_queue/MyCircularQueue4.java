package com.ymt.leetcode.stack_queue.design_circular_queue;

/**
 * @Description 参考题解，只设置一个指针
 * @author yumingtao
 * @date 2022-02-20 12:30
 */
public class MyCircularQueue4 {
    private int head;
    private int[] data;
    private int count;
    private int size;

    public MyCircularQueue4(int k) {
        this.data = new int[k];
        this.head = 0;
        this.count = 0;
        size = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        //tail-head+1=count -> tail=head+count-1
        //int tail = head + count - 1;
        //++tail
        data[(head + count) % size] = value;
        ++count;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        --count;
        if (isEmpty()) {
            head = 0;
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
        return data[(head + count - 1) % size];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }
}
