package com.ymt.leetcode.list.remove_nth_node_from_end_of_list;

/**
 * @description 参考题解
 * @author yumingtao
 * @date 2022-07-17 20:33
 */
public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int len = 0;
        while (node != null) {
            ++len;
            node = node.next;
        }
        node = new ListNode(-1, head);
        ListNode curr = node;
        for (int i = 0; i < len - n; ++i) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return node.next;
    }
}
