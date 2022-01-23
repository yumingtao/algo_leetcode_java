package com.ymt.leetcode.two_pointers.middle_of_the_linked_list;

/**
 * @Description 使用快慢指针
 * @author yumingtao
 * @date 2022-01-23 14:43
 */
public class Solution3 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
