package com.ymt.leetcode.list.reverse_linked_list;

/**
 * @description
 * @author yumingtao
 * @date 2022-07-17 15:32
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        //至少两个节点才能反转
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList(head.next);
        //反转节点对，（head，next)，使next.next=head
        head.next.next = head;
        //去除原来的指向关系
        head.next = null;
        return node;
    }
}
