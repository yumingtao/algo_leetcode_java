package com.ymt.leetcode.list.design_linked_list;

/**
 * @description
 * @author yumingtao
 * @date 2022-08-13 19:52
 */
public class MyLinkedList5 {
    private int size;
    private ListNode head;
    private ListNode tail;

    public MyLinkedList5() {
        //head和tail是保护节点，不是链表的真正节点
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public int get(int index) {
        //注意index是从0开始的
        if (index < 0 || index > size - 1) {
            return -1;
        }
        //判断从head还是tail遍历链表，0～size-1是index的有效范围
        //前半段是index-0+1个，后半段是size-1-index+1=size-index个
        if (index + 1 < size - index) {
            //从前往后遍历
            ListNode curr = head;
            //注意此处应该是<index+1，因为长度是index-0+1
            for (int i = 0; i < index + 1; ++i) {
                curr = curr.next;
            }
            return curr.val;
        } else {
            //从后往前遍历
            ListNode curr = tail;
            for (int i = 0; i < size - index; ++i) {
                curr = curr.pre;
            }
            return curr.val;
        }
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

        //找到插入位置的前驱和后继
        ListNode pre;
        ListNode succ;
        //判断从head还是tail遍历链表，0～size-1是index的有效范围
        //前半段是index-0+1个，后半段是size-1-index+1=size-index个
        if (index + 1 < size - index) {
            //从前往后遍历
            pre = head;
            //注意此处应该是<index，找到pre
            for (int i = 0; i < index; ++i) {
                pre = pre.next;
            }
            succ = pre.next;
        } else {
            //从后往前遍历，
            succ = tail;
            for (int i = 0; i < size - index; ++i) {
                succ = succ.pre;
            }
            pre = succ.pre;
        }
        //找到了插入位置的前驱和后继
        ListNode newNode = new ListNode(val);
        newNode.pre = pre;
        newNode.next = succ;
        succ.pre = newNode;
        pre.next = newNode;
        ++size;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            return;
        }
        //找到删除位置的前驱和后继
        ListNode pre;
        ListNode succ;
        //判断从head还是tail遍历链表，0～size-1是index的有效范围
        //前半段是index-0+1个，后半段是size-1-index+1=size-index个
        if (index + 1 < size - index) {
            //从前往后遍历
            pre = head;
            //注意此处应该是<index，找到删除节点的前驱
            for (int i = 0; i < index; ++i) {
                pre = pre.next;
            }
            //找到删除节点的后继
            succ = pre.next.next;
        } else {
            //从后往前遍历
            succ = tail;
            //注意-1，找到删除节点的后继
            for (int i = 0; i < size - index - 1; ++i) {
                succ = succ.pre;
            }
            pre = succ.pre.pre;
        }
        pre.next = succ;
        succ.pre = pre;
        --size;
    }

    class ListNode {
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
