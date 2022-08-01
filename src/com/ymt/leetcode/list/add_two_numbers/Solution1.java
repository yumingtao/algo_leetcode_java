package com.ymt.leetcode.list.add_two_numbers;

/**
 * @description 双指针暴力解法
 * @author yumingtao
 * @date 2022-08-01 21:55
 */
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int mod = 0;
        int value = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + value;
            mod = sum % 10;
            value = sum / 10;
            p.next = new ListNode(mod);
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }

        while (l1 != null) {
            int sum = l1.val + value;
            mod = sum % 10;
            value = sum / 10;
            p.next = new ListNode(mod);
            l1 = l1.next;
            p = p.next;
        }

        while (l2 != null) {
            int sum = l2.val + value;
            mod = sum % 10;
            value = sum / 10;
            p.next = new ListNode(mod);
            l2 = l2.next;
            p = p.next;
        }

        if (value > 0) {
            p.next = new ListNode(value);
        }
        return dummy.next;
    }
}
