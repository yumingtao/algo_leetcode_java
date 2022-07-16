package com.ymt.leetcode.list.design_linked_list;

/**
 * @description 使用双链表
 * @author yumingtao
 * @date 2022-06-19 19:13
 */
public class MyLinkedList4 {
    private int size;
    private ListNode head;
    private ListNode tail;

    public MyLinkedList4() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode current;
        //index+1<size-index,计算从头和尾开始找index谁最快
        if (index + 1 < size - index) {
            //从头开始找
            current = head;
            for (int i = 0; i < index + 1; ++i) {
                current = current.next;
            }
        } else {
            //从尾开始找
            current = tail;
            for (int i = 0; i < size - index; ++i) {
                current = current.pre;
            }
        }
        return current.val;
    }

    public void addAtHead(int val) {
        ListNode pre = head;
        ListNode succ = head.next;
        ListNode newNode = new ListNode(val);
        pre.next = newNode;
        newNode.pre = pre;
        newNode.next = succ;
        succ.pre = newNode;
        ++size;
    }

    public void addAtTail(int val) {
        ListNode succ = tail;
        ListNode pre = tail.pre;
        ListNode newNode = new ListNode(val);
        pre.next = newNode;
        newNode.pre = pre;
        newNode.next = succ;
        succ.pre = newNode;
        ++size;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }

        ListNode pre;
        ListNode succ;
        //index+1<size-index,计算从头和尾开始找index谁最快
        if (index + 1 < size - index) {
            //从头开始找
            pre = head;
            for (int i = 0; i < index; ++i) {
                pre = pre.next;
            }
            succ = pre.next;
        } else {
            //从尾开始找,注意此处找到index的节点，pre就是他的前驱节点
            succ = tail;
            for (int i = 0; i < size - index; ++i) {
                succ = succ.pre;
            }
            pre = succ.pre;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = succ;
        succ.pre = newNode;
        newNode.pre = pre;
        pre.next = newNode;
        ++size;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode pre;
        ListNode succ;
        //index+1<size-index,计算从头和尾开始找index谁最快
        if (index + 1 < size - index) {
            //从头开始找
            pre = head;
            for (int i = 0; i < index; ++i) {
                pre = pre.next;
            }
            succ = pre.next.next;
        } else {
            //从尾开始找，注意此处是找到index的后继节点，所以要减1
            succ = tail;
            for (int i = 0; i < size - index - 1; ++i) {
                succ = succ.pre;
            }
            pre = succ.pre.pre;
        }

        pre.next = succ;
        succ.pre = pre;
        --size;
    }
}
