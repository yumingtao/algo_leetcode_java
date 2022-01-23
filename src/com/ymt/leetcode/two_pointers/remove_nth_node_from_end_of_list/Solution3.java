package com.ymt.leetcode.two_pointers.remove_nth_node_from_end_of_list;

/**
 * @Description 题解：暴力两次遍历
 * @author yumingtao
 * @date 2022-01-23 10:34
 */
public class Solution3 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0, head);
        int count = 0;
        while (head != null) {
            ++count;
            head = head.next;
        }
        ListNode cur = pre;
        for (int i = 1; i < count - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return pre.next;
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
