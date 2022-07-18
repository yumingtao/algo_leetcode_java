package com.ymt.leetcode.list.remove_nth_node_from_end_of_list;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 使用List
 * @author yumingtao
 * @date 2022-07-17 19:48
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }
        ListNode pre = new ListNode(-1);
        head = pre;
        for (int i = 0; i < nodes.size(); ++i) {
            if (i != nodes.size() - n) {
                pre.next = nodes.get(i);
                pre = pre.next;
            }
        }
        pre.next = null;
        return head.next;
    }
}
