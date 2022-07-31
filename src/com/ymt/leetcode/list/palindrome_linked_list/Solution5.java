package com.ymt.leetcode.list.palindrome_linked_list;

/**
 * @description Solution3 优化
 * @author yumingtao
 * @date 2022-07-31 14:08
 */
public class Solution5 {
    private ListNode p;

    public boolean isPalindrome(ListNode head) {
        p = head;
        return check(head);
    }

    private boolean check(ListNode curr) {
        if (curr == null) {
            return true;
        }
        boolean result = check(curr.next);
        if (result) {
            if (p.val == curr.val) {
                p = p.next;
                return true;
            }
        }
        return false;
    }
}
