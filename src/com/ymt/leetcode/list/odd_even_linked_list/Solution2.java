package com.ymt.leetcode.list.odd_even_linked_list;

/**
 * @description 题解实现
 * @author yumingtao
 * @date 2022-07-31 19:41
 */
public class Solution2 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
