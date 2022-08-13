package com.ymt.leetcode.list.add_two_numbers;

/**
 * @description 题解
 * @author yumingtao
 * @date 2022-08-13 16:09
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int value = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + value;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            value = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (value > 0) {
            tail.next = new ListNode(value);
        }
        return head;
    }
}
