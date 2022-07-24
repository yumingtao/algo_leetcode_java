package com.ymt.leetcode.list.lcof3u1WK4;

/**
 * @description 使用双指针
 * @author yumingtao
 * @date 2022-07-24 12:24
 */
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
            if (pA == null && pB != null) {
                pA = headB;
            }
            if (pB == null && pA != null) {
                pB = headA;
            }
        }
        return pA;
    }
}
