package com.ymt.leetcode.list.remove_duplicate_node_lcci;

/**
 * @description 双指针优化
 * @author yumingtao
 * @date 2022-07-24 14:34
 */
public class Solution4 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        while (first != null) {
            ListNode curr = first;
            while (curr.next != null) {
                if (first.val == curr.next.val) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
            first = first.next;
        }
        return head;
    }
}
