package com.ymt.leetcode.list.copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @author yumingtao
 * @date 2022-08-21 15:05
 */
public class Solution3 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //key-原节点，value-原节点的复制节点
        Map<Node, Node> cachedNode = new HashMap<>();
        //先将原节点存入cacheNodes
        Node cur = head;
        while (cur != null) {
            cachedNode.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        //处理复制节点的指向关系
        cur = head;
        while (cur != null) {
            cachedNode.get(cur).next = cachedNode.get(cur.next);
            cachedNode.get(cur).random = cachedNode.get(cur.random);
            cur = cur.next;
        }
        return cachedNode.get(head);
    }
}
