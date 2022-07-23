package com.ymt.leetcode.list.remove_duplicates_from_sorted_list;

/**
 * @description 使用双指针
 * @author yumingtao
 * @date 2022-07-23 15:00
 */
public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null) {
            if (p1.val == p2.val) {
                p2 = p2.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
            p1.next = p2;
        }
        return head;
    }
}
