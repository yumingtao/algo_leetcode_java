package com.ymt.leetcode.list.flatten_a_multilevel_doubly_linked_list;

/**
 * @description
 * @author yumingtao
 * @date 2022-08-14 15:31
 */
public class Solution1 {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node next = flatten(head.next);
        Node child = flatten(head.child);

        if (child != null) {
            //如果child不为null，将clild连接到head之后，再将next连接到child之后
            head.child = null;
            head.next = child;
            child.prev = head;
            Node childLast = child;
            while (child != null) {
                childLast = child;
                child = child.next;
            }
            //将child的最后一个节点与next连接
            if (next != null) {
                childLast.next = next;
                next.prev = childLast;
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
