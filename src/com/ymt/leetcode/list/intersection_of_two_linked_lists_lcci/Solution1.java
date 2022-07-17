package com.ymt.leetcode.list.intersection_of_two_linked_lists_lcci;

import java.util.HashSet;
import java.util.Set;

/**
 * @description 使用Set
 * @author yumingtao
 * @date 2022-07-17 12:16
 */
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
