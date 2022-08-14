package com.ymt.leetcode.list.design_linked_list;

/**
 * @description 题解理解
 * @author yumingtao
 * @date 2022-08-14 12:12
 */
public class MyLinkedList6 {
    private int size;
    private ListNode head;
    private ListNode tail;

    public MyLinkedList6() {
        //head和tail只是作为保护节点
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public int get(int index) {
        //index的有效范围0～size-1
        if (index < 0 || index > size - 1) {
            return -1;
        }
        //判断从前往后找还是从后往前找，提高遍历速度
        //前半段的长度index-0+1，后半段长度size-1-index+1=size-index
        ListNode curr;
        if (index + 1 < size - index) {
            //从head开始遍历
            curr = head;
            for (int i = 0; i < index + 1; ++i) {
                curr = curr.next;
            }
        } else {
            //从tail开始遍历
            curr = tail;
            for (int i = 0; i < size - index; ++i) {
                curr = curr.pre;
            }
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        ListNode pre = head;
        ListNode succ = head.next;
        //即在pre和succ之间插入节点
        ListNode newNode = new ListNode(val);
        //先处理新插入节点
        newNode.next = succ;
        newNode.pre = pre;
        //再处理原来的几点
        pre.next = newNode;
        succ.pre = newNode;
        ++size;
    }

    public void addAtTail(int val) {
        ListNode pre = tail.pre;
        ListNode succ = tail;
        //即在pre和succ之间插入节点
        ListNode newNode = new ListNode(val);
        //先处理新插入节点
        newNode.next = succ;
        newNode.pre = pre;
        //再处理原来的几点
        pre.next = newNode;
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
        //先判断从head还是从tail遍历数组，找到要插入节点的pre和succ
        ListNode pre;
        ListNode succ;
        if (index + 1 < size - index) {
            pre = head;
            //注意此时是要找到index的前驱节点,所以i<index
            for (int i = 0; i < index; ++i) {
                pre = pre.next;
            }
            //现在的pre即是要插入节点的前驱，那么要插入节点的后继就是pre.next
            succ = pre.next;
        } else {
            succ = tail;
            //注意此时是要找到index的节点作为后继节点，所以i<size-index
            for (int i = 0; i < size - index; ++i) {
                succ = succ.pre;
            }
            //现在succ即是要插入节点的后继，那么要插入节点的前驱就是succ.pre
            pre = succ.pre;
        }
        //在pre和succ之间插入新节点
        ListNode newNode = new ListNode(val);
        newNode.pre = pre;
        newNode.next = succ;
        pre.next = newNode;
        succ.pre = newNode;
        ++size;
    }

    public void deleteAtIndex(int index) {
        //index的有效范围是0～index-1
        if (index < 0 || index > size - 1) {
            return;
        }
        //找到要删除节点的前驱和后继，然后让它们关联
        ListNode pre;
        ListNode succ;
        if (index + 1 < size - index) {
            pre = head;
            //注意此时是要找到index的前驱节点,所以i<index
            for (int i = 0; i < index; ++i) {
                pre = pre.next;
            }
            //现在的pre即是要删除节点的前驱，那么他的后继就是pre.next.next
            succ = pre.next.next;
        } else {
            succ = tail;
            //注意此时是要找到index的后继节点，所以i<size-index-1
            for (int i = 0; i < size - index - 1; ++i) {
                succ = succ.pre;
            }
            //现在succ即是要删除节点的后继，那么它的前驱就是succ.pre.pre
            pre = succ.pre.pre;
        }
        //关联删除节点的前驱和后继即可
        pre.next = succ;
        succ.pre = pre;
        --size;
    }
}
