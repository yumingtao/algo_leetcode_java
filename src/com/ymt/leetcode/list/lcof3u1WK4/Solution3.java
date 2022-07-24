package com.ymt.leetcode.list.lcof3u1WK4;

/**
 * @description 使用双指针
 * @author yumingtao
 * @date 2022-07-24 12:26
 */
public class Solution3 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }
            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }
}
