package com.ymt.leetcode.list.design_linked_list;

/**
 * @description
 * @author yumingtao
 * @date 2022-06-19 18:22
 */
public class MyLinkedList3 {
    private int size;
    private ListNode head;
    private ListNode tail;

    public MyLinkedList3() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode current = head;
        for(int i = 0; i < index + 1; ++i){
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index < 0){
            index = 0;
        }

        ListNode pre = head;
        for(int i = 0; i < index; ++i){
            pre = pre.next;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next.pre = newNode;
        newNode.pre = pre;
        pre.next = newNode;
        ++size;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        ListNode pre = head;
        for(int i = 0; i < index; ++i){
            pre = pre.next;
        }
        pre.next.next.pre = pre;
        pre.next = pre.next.next;
        --size;
    }
}
