package com.ymt.leetcode.two_pointers.intersection_of_two_linked_lists;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Description 使用set
 * @author yumingtao
 * @date 2022-01-23 16:12
 */
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> setA = new HashSet<>();
        ListNode curA = headA;
        while (curA != null) {
            setA.add(curA);
            curA = curA.next;
        }

        ListNode curB = headB;
        while (curB != null) {
            if (setA.contains(curB)) {
                return curB;
            }
            curB = curB.next;
        }
        return null;
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
