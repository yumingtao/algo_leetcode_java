package com.ymt.leetcode.recursion_divide_conquer.merge_two_sorted_lists;

/**
 * @Description 双指针优化
 * @author yumingtao
 * @date 2022-04-05 12:09
 */
public class Solution2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode();
        ListNode head = newList;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                newList.next = p1;
                p1 = p1.next;
            } else {
                newList.next = p2;
                p2 = p2.next;
            }
            newList = newList.next;
        }

        if (p1 != null) {
            newList.next = p1;
        }

        if (p2 != null) {
            newList.next = p2;
        }

        return head.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
