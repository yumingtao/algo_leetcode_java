package com.ymt.leetcode.list.remove_nth_node_from_end_of_list;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description 使用栈
 * @author yumingtao
 * @date 2022-07-18 09:28
 */
public class Solution3 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Deque<ListNode> nodeDeque = new LinkedList<>();
        ListNode pre = new ListNode(-1, head);
        ListNode node = pre;
        while (node != null) {
            nodeDeque.add(node);
            node = node.next;
        }

        while (!nodeDeque.isEmpty()) {
            --n;
            if (n == 0) {
                //得到要删除节点
                ListNode curr = nodeDeque.pollLast();
                //得到要删除节点的前驱节点
                ListNode currPre = nodeDeque.pollLast();
                currPre.next = curr.next;
                curr.next = null;
                break;
            }
            nodeDeque.pollLast();
        }
        return pre.next;
    }
}
