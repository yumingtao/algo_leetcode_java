package com.ymt.leetcode.list.copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @author yumingtao
 * @date 2022-08-21 15:05
 */
public class Soltuion3 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> cachedNode = new HashMap<>();
        while (cur != null) {
            cachedNode.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            cachedNode.get(cur).next = cachedNode.get(cur.next);
            cachedNode.get(cur).random = cachedNode.get(cur.random);
            cur = cur.next;
        }
        return cachedNode.get(head);
    }
}
