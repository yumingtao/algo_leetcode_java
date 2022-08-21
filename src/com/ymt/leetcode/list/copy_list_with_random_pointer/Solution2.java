package com.ymt.leetcode.list.copy_list_with_random_pointer;

/**
 * @description 参考题解，迭代
 * @author yumingtao
 * @date 2022-08-21 14:58
 */
public class Solution2 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //先将node节点的copy节点挂在next指针上, 因为中间插入了copy节点，所以迭代的时候是.next.next
        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = new Node(node.val);
            //先将node节点的next节点挂在新节点的next
            newNode.next = node.next;
            //将newNode挂在node节点的next指针
            node.next = newNode;
        }

        //处理新加入节点的random, 原节点的random节点的next节点就是新节点的random节点
        for (Node node = head; node != null; node = node.next.next) {
            //新节点是当前节点的next
            Node newNode = node.next;
            newNode.random = node.random == null ? null : node.random.next;
        }

        //最后提取新节点成一个链表
        //head.next是新链表的第一个节点
        Node newHead = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node newNode = node.next;
            //恢复原来节点的链接关系
            node.next = newNode.next;
            newNode.next = newNode.next == null ? null : newNode.next.next;
        }
        return newHead;
    }
}
