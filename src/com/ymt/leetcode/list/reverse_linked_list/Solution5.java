package com.ymt.leetcode.list.reverse_linked_list;

/**
 * @description 题解理解
 * @author yumingtao
 * @date 2022-07-30 15:12
 */
public class Solution5 {
    public ListNode reverseList(ListNode head) {
        //特例判断
        if (head == null) {
            return null;
        }
        /*
        head  head.next  head.next.next
        curr
        */
        ListNode curr = head;
        while (head.next != null) {
            ListNode t = head.next.next;
            head.next.next = curr;
            curr = head.next;
            head.next = t;
        }
        return curr;
    }
}
