package com.ymt.leetcode.list.remove_nth_node_from_end_of_list;

/**
 * @description 使用双指针，Solution5改进
 * @author yumingtao
 * @date 2022-07-23 11:31
 */
public class Solution6 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode dummy = new ListNode(-1, head);
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
