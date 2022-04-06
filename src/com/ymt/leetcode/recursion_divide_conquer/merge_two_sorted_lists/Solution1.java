package com.ymt.leetcode.recursion_divide_conquer.merge_two_sorted_lists;

/**
 * @Description 双指针
 * @author yumingtao
 * @date 2022-04-05 11:52
 */
public class Solution1 {
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

        while (p1 != null) {
            newList.next = p1;
            p1 = p1.next;
            newList = newList.next;
        }

        while (p2 != null) {
            newList.next = p2;
            p2 = p2.next;
            newList = newList.next;
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
