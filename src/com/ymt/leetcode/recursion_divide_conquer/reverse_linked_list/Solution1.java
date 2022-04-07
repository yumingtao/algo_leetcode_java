package com.ymt.leetcode.recursion_divide_conquer.reverse_linked_list;

/**
 * @Description
 * @author yumingtao
 * @date 2022/4/7 09:09
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode current;
        ListNode curNext;
        while (head != null) {
            current = head;
            curNext = head.next;
            head.next = last;
            head = curNext;
            last = current;
        }
        return last;
    }
}
