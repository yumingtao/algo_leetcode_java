package com.ymt.leetcode.list.reverse_linked_list;

/**
 * @description 题解理解
 * @author yumingtao
 * @date 2022-07-30 14:23
 */
public class Solution4 {
    public ListNode reverseList(ListNode head) {
        //特例判断
        if (head == null) {
            return null;
        }
        //找到反转后的头节点的条件
        if (head.next == null) {
            return head;
        }
        //通过递归找得反转后的头节点
        ListNode newHead = reverseList(head.next);
        //逻辑主体，当前节点的下一个节点指向当前节点
        head.next.next = head;
        head.next = null;
        //每次递归都返回反转后的头节点
        return newHead;
    }
}
