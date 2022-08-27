package com.ymt.leetcode.list.rotate_list;

import java.util.ArrayList;
import java.util.List;

/**
 * @description java利用数组暴力
 * @author yumingtao
 * @date 2022-08-27 15:33
 */
public class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int len = nodes.size();
        ListNode[] nodeArray = new ListNode[len];
        for (int i = 0; i < len; ++i) {
            ListNode node = nodes.get(i);
            nodeArray[(i + k) % len] = node;
            node.next = null;
        }

        ListNode newHead = nodeArray[0];
        ListNode cur = newHead;
        for (int i = 1; i < len; ++i) {
            cur.next = nodeArray[i];
            cur = cur.next;
        }

        return newHead;
    }
}
