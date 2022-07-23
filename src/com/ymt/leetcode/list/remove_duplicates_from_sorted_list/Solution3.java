package com.ymt.leetcode.list.remove_duplicates_from_sorted_list;

/**
 * @description 题解方法一次遍历
 * @author yumingtao
 * @date 2022-07-23 15:11
 */
public class Solution3 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
