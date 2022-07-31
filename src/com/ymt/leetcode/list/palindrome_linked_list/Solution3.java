package com.ymt.leetcode.list.palindrome_linked_list;

/**
 * @description 递归实现
 * @author yumingtao
 * @date 2022-07-31 13:32
 */
public class Solution3 {
    private ListNode p;

    public boolean isPalindrome(ListNode head) {
        p = head;
        return check(head);
    }

    private boolean check(ListNode curr) {
        if (curr.next == null) {
            return isEquals(curr);
        }
        boolean result = check(curr.next);
        if (result) {
            return isEquals(curr);
        }
        return false;
    }

    private boolean isEquals(ListNode node) {
        if (p.val == node.val) {
            p = p.next;
            return true;
        }
        return false;
    }
}
