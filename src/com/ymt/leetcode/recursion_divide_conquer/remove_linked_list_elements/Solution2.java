package com.ymt.leetcode.recursion_divide_conquer.remove_linked_list_elements;

/**
 * @Description 迭代
 * @author yumingtao
 * @date 2022-04-18 22:12
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        //定义新的头节点等于当前头节点
        ListNode newHead = head;
        //定义新的节点node用于结果返回
        ListNode node = newHead;
        while (head != null) {
            if (head.val == val) {
                //如果head当前节点的val等于val，则在新链表中舍弃该节点，直接指向head当前节点的下一个节点
                newHead.next = head.next;
            } else {
                ////如果head当前节点的val等于val，则在新链表中保留head的该节点
                newHead = head;
            }
            //继续迭代
            head = head.next;
        }
        //判断如果head的第一个节点的val就是val的情况
        return node == null ? null : (node.val == val ? node.next : node);
    }
}
