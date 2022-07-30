package com.ymt.leetcode.list.reverse_linked_list;

/**
 * @description 题解双指针
 * @author yumingtao
 * @date 2022-07-30 15:17
 */
public class Solution6 {
    public ListNode reverseList(ListNode head) {
       /*
       双指针：
        curr pre
       */
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode t = pre.next;
            pre.next = curr;
            curr = pre;
            pre = t;
        }
        return curr;
    }
}
