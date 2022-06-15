package com.ymt.leetcode.recursion_divide_conquer.remove_linked_list_elements;

/**
 * @Description
 * @author yumingtao
 * @date 2022-04-23 15:07
 */
public class Solution5 {
    public ListNode removeElements(ListNode head, int val) {
        //新建一个虚拟节点指向head，来处理head的第一个节点的val就等于参数中val的情况
        ListNode prorect = new ListNode(-1);
        prorect.next = head;
        //新建一个节点指向protect，做为迭代指针遍历protect
        ListNode node = prorect;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return prorect.next;
    }
}
