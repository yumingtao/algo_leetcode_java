package com.ymt.leetcode.list.he_bing_liang_ge_pai_xu_de_lian_biao_lcof;

/**
 * @description 题解-递归
 * @author yumingtao
 * @date 2022-08-13 16:40
 */
public class Solution3 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
