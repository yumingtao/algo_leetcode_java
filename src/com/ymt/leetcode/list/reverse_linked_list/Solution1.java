package com.ymt.leetcode.list.reverse_linked_list;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author yumingtao
 * @date 2022-07-17 14:44
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        List<ListNode> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }

        ListNode node = new ListNode(-1);
        ListNode p = node;
        for (int i = nodeList.size() - 1; i >= 0; --i) {
            node.next = nodeList.get(i);
            node = node.next;
        }
        node.next = null;
        return p.next;
    }
}
