package com.ymt.leetcode.list.remove_linked_list_elements;

/**
 * @description
 * @author yumingtao
 * @date 2022-07-30 18:41
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode node = dummy;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return dummy.next;
    }
}
