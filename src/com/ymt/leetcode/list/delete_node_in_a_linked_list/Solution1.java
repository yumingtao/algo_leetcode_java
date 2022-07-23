package com.ymt.leetcode.list.delete_node_in_a_linked_list;

/**
 * @description 将下一个节点的值赋值给当前节点
 * @author yumingtao
 * @date 2022-07-23 13:52
 */
public class Solution1 {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
