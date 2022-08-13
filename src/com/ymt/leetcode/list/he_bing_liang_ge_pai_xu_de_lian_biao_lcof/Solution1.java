package com.ymt.leetcode.list.he_bing_liang_ge_pai_xu_de_lian_biao_lcof;

/**
 * @description
 * @author yumingtao
 * @date 2022-08-13 16:29
 */
public class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }

        while (l1 != null) {
            p.next = l1;
            l1 = l1.next;
            p = p.next;
        }

        while (l2 != null) {
            p.next = l2;
            l2 = l2.next;
            p = p.next;
        }

        return dummy.next;
    }
}
