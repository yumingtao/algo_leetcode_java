package com.ymt.leetcode.list.flatten_a_multilevel_doubly_linked_list;

/**
 * @description Solution4优化
 * @author yumingtao
 * @date 2022-08-14 16:56
 */
public class Solution5 {
    public Node flatten(Node head) {
        //head的上级next节点为null
        return process(head, null);
    }

    private Node process(Node head, Node parentNext) {
        if (head == null) {
            return null;
        }
        Node last = head;
        if (head.child != null) {
            //先处理child节点,并将当前的head的next带入到递归
            Node child = process(head.child, head.next);
            //将head.child置空
            head.child = null;
            //得到child节点后，将child节点挂到head后边,child至少有一个节点，肯定不为null
            head.next = child;
            child.prev = head;
            last = child;
            while (last.next != null) {
                last = last.next;
            }
        }

        if (last.next != null) {
            //如果没有head没有child节点，那么last就是head，否则last就是连接完child后的，最后一个非null节点
            //处理当前节点的next，同时把上一层递归过来的next传下去
            Node currNext = process(last.next, parentNext);
            last.next = currNext;
            currNext.prev = last;
        } else if (parentNext != null) {
            //直接将head.next赋值为上级next节点
            //注意判断上级next节点为null的情况
            last.next = parentNext;
            parentNext.prev = last;
        }
        return head;
    }
}
