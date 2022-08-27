package com.ymt.leetcode.list.copy_list_with_random_pointer;

/**
 * @description
 * @author yumingtao
 * @date 2022-08-27 12:36
 */
public class Solution4 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //将当前节点的复制节点挂到当前节点的后边
        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }

        //再处理random节点
        for (Node node = head; node != null; node = node.next.next) {
            if (node.random != null) {
                //复制节点的random恰好是原节点random的next
                node.next.random = node.random.next;
            }
        }
        Node newHead = head.next;
        Node cur = newHead;
        //摘出复制节点组成新的链表
        for (Node node = head; node != null; node = node.next) {
            //恢复原链表，即删除复制节点
            node.next = node.next.next;
            //此时node节点指向的是原节点的下一个节点，如果node.next不为null，继续处理复制节点
            if (node.next != null) {
                cur.next = node.next.next;
                cur = cur.next;
            }
        }
        return newHead;
    }
}
