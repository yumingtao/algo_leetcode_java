package com.ymt.leetcode.two_pointers.linked_list_cycle_ii;

/**
 * @Description 参考官方题解
 * @author yumingtao
 * @date 2022-01-24 22:16
 */
public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        //判断0和1个节点的情况
        if (head == null || head.next == null) {
            return null;
        }
        //每次slow走1步，fast走两步，使得fast=2*slow
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        ListNode meet = null;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                //没有环，直接返回null
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow和fast相等，找到了相遇点meet
        meet = slow;//或meet=fast;
        //head到入环点距离是a，从入环点到相遇点距离是b，相遇点到入环点距离是c
        //相遇时slow走了a+b，fast走了a+b+c+b
        //因为fast=2*slow -> a+b+c+b=2*(a+b) -> a=c,即从head和相遇点meet开始走，每次走一步，会在入环点相遇
        while (meet != head) {
            meet = meet.next;
            head = head.next;
        }
        return head;
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
