package com.ymt.leetcode.list.remove_linked_list_elements;

/**
 * @description
 * @author yumingtao
 * @date 2022-07-30 18:24
 */
public class Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
