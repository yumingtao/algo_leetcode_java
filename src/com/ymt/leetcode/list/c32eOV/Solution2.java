package com.ymt.leetcode.list.c32eOV;

/**
 * @description 使用快慢指针
 * @author yumingtao
 * @date 2022-07-24 15:21
 */
public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        //空链表或一个节点的链表不能形成环，直接返回null
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
}
