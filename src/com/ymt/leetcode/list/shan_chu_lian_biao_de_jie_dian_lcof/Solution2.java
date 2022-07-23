package com.ymt.leetcode.list.shan_chu_lian_biao_de_jie_dian_lcof;

/**
 * @description
 * @author yumingtao
 * @date 2022-07-23 13:28
 */
public class Solution2 {
    public ListNode deleteNode(ListNode head, int val) {
        //该判断可以去掉，不存在空链表[]
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
                break;
            }
            pre = pre.next;
            curr = curr.next;
        }
        return head;
    }
}
