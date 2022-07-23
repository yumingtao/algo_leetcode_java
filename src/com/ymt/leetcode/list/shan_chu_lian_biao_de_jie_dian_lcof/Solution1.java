package com.ymt.leetcode.list.shan_chu_lian_biao_de_jie_dian_lcof;

/**
 * @description
 * @author yumingtao
 * @date 2022-07-23 13:19
 */
public class Solution1 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head;
        ListNode pre = dummy;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
                break;
            }
            pre = pre.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
