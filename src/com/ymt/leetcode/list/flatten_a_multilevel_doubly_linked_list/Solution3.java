package com.ymt.leetcode.list.flatten_a_multilevel_doubly_linked_list;

/**
 * @description
 * @author yumingtao
 * @date 2022-08-14 16:31
 */
public class Solution3 {
    public Node flatten(Node head) {
        //head的上级next节点为null
        return process(head, null);
    }

    private Node process(Node head, Node next) {
        if (head == null) {
            return null;
        }
        if (head.child != null) {
            //先处理child节点,并将当前的head的next带入到递归
            Node child = process(head.child, head.next);
            //将head.child置空
            head.child = null;
            //得到child节点后，将child节点挂到head后边
            if (child != null) {
                head.next = child;
                child.prev = head;
            }
        }
        if (head.next != null) {
            //处理当前节点的next，同时把上一层递归过来的next传下去
            Node currNext = process(head.next, next);
            if (currNext != null) {
                head.next = currNext;
                currNext.prev = head;
            } else {
                //注意判断上级next节点为null的情况
                if (next != null) {
                    head.next = next;
                    next.prev = head;
                }
            }
        } else {
            //注意判断上级next节点为null的情况
            if (next != null) {
                head.next = next;
                next.prev = head;
            }
        }
        return head;
    }
}
