package com.ymt.leetcode.list.shan_chu_lian_biao_de_jie_dian_lcof;

/**
 * @description 题解实现
 * @author yumingtao
 * @date 2022-07-23 13:30
 */
public class Solution3 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null && curr.val != val) {
            pre = pre.next;
            curr = curr.next;
        }
        if (curr != null) {
            pre.next = curr.next;
        }
        return head;
    }
}
