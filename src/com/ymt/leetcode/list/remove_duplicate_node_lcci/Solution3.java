package com.ymt.leetcode.list.remove_duplicate_node_lcci;

/**
 * @description 使用双重循环
 * @author yumingtao
 * @date 2022-07-24 14:22
 */
public class Solution3 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        while (first != null) {
            ListNode pre = first;
            ListNode curr = pre.next;
            while (curr != null) {
                if (first.val == curr.val) {
                    pre.next = curr.next;
                } else {
                    pre = pre.next;
                }
                curr = curr.next;
            }
            first = first.next;
        }
        return head;
    }
}
