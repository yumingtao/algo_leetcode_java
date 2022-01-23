package com.ymt.leetcode.two_pointers.middle_of_the_linked_list;

/**
 * @Description 单指针两次遍历
 * @author yumingtao
 * @date 2022-01-23 14:32
 */
public class Solution2 {
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            ++count;
            cur = cur.next;
        }
        for (int i = 0; i < count / 2; ++i) {
            head = head.next;
        }
        return head;
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
