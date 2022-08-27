package com.ymt.leetcode.list.copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 参考题解，使用递归
 * @author yumingtao
 * @date 2022-08-21 13:04
 */
public class Solution1 {
    //保存当前节点创建的新节点
    Map<Node, Node> cachedNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node newHead = new Node(head.val);
            cachedNode.put(head, newHead);
            //递归处理复制节点的next
            newHead.next = copyRandomList(head.next);
            //递归处理复制节点的random
            newHead.random = copyRandomList(head.random);
        }
        //如果当前节点的新节点已经创建，直接返回即可
        return cachedNode.get(head);
    }
}
