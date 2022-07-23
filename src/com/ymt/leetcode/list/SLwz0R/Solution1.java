package com.ymt.leetcode.list.SLwz0R;

/**
 * @description
 * @author yumingtao
 * @date 2022-07-23 15:22
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while (first != null) {
            first = first.next;
            second = second.next;
            pre = pre.next;
        }
        pre.next = second.next;
        return dummy.next;
    }
}
