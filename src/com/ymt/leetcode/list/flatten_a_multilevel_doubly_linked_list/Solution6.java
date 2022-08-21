package com.ymt.leetcode.list.flatten_a_multilevel_doubly_linked_list;

/**
 * @description 题解dfs
 * @author yumingtao
 * @date 2022-08-14 17:54
 */
public class Solution6 {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node node) {
        Node curr = node;
        Node last = null;
        //遍历节点
        while (curr != null) {
            Node next = curr.next;
            if (curr.child != null) {
                //如果存在child, 将curr和child相连
                curr.next = curr.child;
                curr.child.prev = curr;
                //遍历child
                Node childLast = dfs(curr.child);
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }
                curr.child = null;
                last = childLast;
            } else {
                last = curr;
                curr = next;
            }
        }
        return last;
    }
}
