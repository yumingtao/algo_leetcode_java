package com.ymt.leetcode.two_pointers.intersection_of_two_linked_lists;

import java.util.Stack;

/**
 * @Description 双Stack解决方案
 * @author yumingtao
 * @date 2022-01-23 14:57
 */
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        ListNode curA = headA;
        while (curA != null) {
            stackA.push(curA);
            curA = curA.next;
        }

        Stack<ListNode> stackB = new Stack<>();
        ListNode curB = headB;
        while (curB != null) {
            stackB.push(curB);
            curB = curB.next;
        }

        ListNode cur = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() != stackB.peek()) {
                break;
            }
            cur = stackA.pop();
            stackB.pop();
        }
        return cur;
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
