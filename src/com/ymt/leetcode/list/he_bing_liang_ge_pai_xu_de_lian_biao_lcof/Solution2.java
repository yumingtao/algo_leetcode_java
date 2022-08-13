package com.ymt.leetcode.list.he_bing_liang_ge_pai_xu_de_lian_biao_lcof;

/**
 * @description Solution1优化
 * @author yumingtao
 * @date 2022-08-13 16:33
 */
public class Solution2 {
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

        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }
        return dummy.next;
    }
}
