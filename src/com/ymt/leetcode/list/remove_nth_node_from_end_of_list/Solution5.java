package com.ymt.leetcode.list.remove_nth_node_from_end_of_list;

/**
 * @description 使用双指针
 * @author yumingtao
 * @date 2022-07-23 11:31
 */
public class Solution5 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        ListNode dummy = new ListNode(-1, second);
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
