package com.ymt.leetcode.list.remove_nth_node_from_end_of_list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description 使用栈
 * @author yumingtao
 * @date 2022-07-18 12:04
 */
public class Solution4 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Deque<ListNode> nodeDeque = new LinkedList<>();
        ListNode dummy = new ListNode(-1, head);
        ListNode node = dummy;
        while (node != null) {
            nodeDeque.push(node);
            node = node.next;
        }
        for (int i = 0; i < n; ++i) {
            nodeDeque.pop();
        }
        ListNode pre = nodeDeque.pop();
        pre.next = pre.next.next;
        return dummy.next;
    }
}
