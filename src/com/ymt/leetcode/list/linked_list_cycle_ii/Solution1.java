package com.ymt.leetcode.list.linked_list_cycle_ii;

/**
 * @description 使用快慢指针
 * @author yumingtao
 * @date 2022-07-16 14:03
 */
public class Solution1 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        ListNode temp = head;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                //相遇了,slow和temp同时一步一步走，最终会在入环点相遇
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return null;
    }
}
