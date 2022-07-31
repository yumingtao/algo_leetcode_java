package com.ymt.leetcode.list.palindrome_linked_list;

/**
 * @description
 * @author yumingtao
 * @date 2022-07-31 14:01
 */
public class Solution4 {
    private ListNode p;

    public boolean isPalindrome(ListNode head) {
        p = head;
        return check(head);
    }

    private boolean check(ListNode curr) {
        if (curr != null) {
            if (!check(curr.next) || p.val != curr.val) {
                return false;
            }
            p = p.next;
        }
        return true;
    }
}
