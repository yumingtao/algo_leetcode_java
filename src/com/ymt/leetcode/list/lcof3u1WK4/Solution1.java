package com.ymt.leetcode.list.lcof3u1WK4;

import java.util.HashSet;
import java.util.Set;

/**
 * @description 使用Set
 * @author yumingtao
 * @date 2022-07-24 12:11
 */
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        while (headA != null) {
            visited.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (visited.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
