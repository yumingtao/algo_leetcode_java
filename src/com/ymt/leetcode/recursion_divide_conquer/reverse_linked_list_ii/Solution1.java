package com.ymt.leetcode.recursion_divide_conquer.reverse_linked_list_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @author yumingtao
 * @date 2022-05-02 12:43
 */
public class Solution1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        ListNode node = new ListNode(0);
        ListNode protect = node;
        for (int i = 0; i < left - 1; ++i) {
            node.next = nodes.get(i);
            node = node.next;
        }

        for (int i = right - 1; i >= left - 1; --i) {
            node.next = nodes.get(i);
            node = node.next;
        }

        for (int i = right; i < nodes.size(); ++i) {
            node.next = nodes.get(i);
            node = node.next;
        }

        node.next = null;
        return protect.next;
    }
}
