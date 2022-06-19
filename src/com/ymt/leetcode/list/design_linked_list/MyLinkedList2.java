package com.ymt.leetcode.list.design_linked_list;

/**
 * @description
 * @author yumingtao
 * @date 2022-06-19 17:51
 */
public class MyLinkedList2 {
    private Node head;
    private int size;
    public MyLinkedList2() {
        this.size = 0;
        head = new Node(0);
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        Node current = head;
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

        Node pre = head;
        for(int i = 0; i < index; ++i){
            pre = pre.next;
        }
        Node newNode = new Node(val);
        newNode.next = pre.next;
        pre.next = newNode;
        ++size;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        Node pre = head;
        for(int i = 0; i < index; ++i){
            pre = pre.next;
        }
        pre.next = pre.next.next;
        --size;
    }
}
