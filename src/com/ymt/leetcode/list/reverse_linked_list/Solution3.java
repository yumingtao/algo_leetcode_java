package com.ymt.leetcode.list.reverse_linked_list;

/**
 * @description 使用迭代
 * @author yumingtao
 * @date 2022-07-17 15:33
 */
public class Solution3 {
    public ListNode reverseList(ListNode head) {
        //反转每两个节点，先定义一个null节点pre，作为当前节点的前置节点
        //反转pre和head
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
