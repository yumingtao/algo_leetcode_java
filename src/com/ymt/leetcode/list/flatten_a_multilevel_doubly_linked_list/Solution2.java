package com.ymt.leetcode.list.flatten_a_multilevel_doubly_linked_list;

/**
 * @description
 * @author yumingtao
 * @date 2022-08-14 15:38
 */
public class Solution2 {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node next = flatten(head.next);
        Node child = flatten(head.child);

        if (child != null) {
            //如果child不为null，将clild连接到head之后，再将next连接到child之后
            //将head.child置空
            head.child = null;
            //连接head和child的头节点
            head.next = child;
            child.prev = head;
            while (child.next != null) {
                child = child.next;
            }
            //将child的最后一个节点与next连接
            if (next != null) {
                child.next = next;
                next.prev = child;
            }
        } else {
            //如果没有child，将head与next连接
            if (next != null) {
                head.next = next;
                next.prev = head;
            }
        }
        return head;
    }
}
