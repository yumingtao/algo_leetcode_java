package com.ymt.leetcode.two_pointers.intersection_of_two_linked_lists;

/**
 * @Description 官方题解
 * @author yumingtao
 * @date 2022-01-23 16:21
 */
public class Solution3 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        //分别执行一个链表走完再走另一个链表，最终他们会在第一个相交节点相遇
        //a-c+b=a-b+c，c是公共部分
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
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
