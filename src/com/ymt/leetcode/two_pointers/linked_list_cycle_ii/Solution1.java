package com.ymt.leetcode.two_pointers.linked_list_cycle_ii;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 参考环形链表i的Solution1
 * @author yumingtao
 * @date 2022-01-24 21:05
 */
public class Solution1 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
