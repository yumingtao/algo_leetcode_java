package com.ymt.leetcode.recursion_divide_conquer.swap_nodes_in_pairs;

/**
 * @Description 使用迭代
 * @author yumingtao
 * @date 2022-04-23 18:22
 */
public class Solution3 {
    public ListNode swapPairs(ListNode head) {
        ListNode protect = new ListNode(-1);
        protect.next = head;
        ListNode node = protect;
        while (node.next != null && node.next.next != null) {
            //当前pair中的第一个和第二个节点
            ListNode first = node.next;
            ListNode seconde = node.next.next;
            //当前pair的第一个节点变为新链表中的第二个节点，指向下一个pair的第一个节点
            first.next = seconde.next;
            //当前pair的第一个节点变为新链表中的第一个节点，让它指向当前的第一个节点
            seconde.next = first;
            //node节点指向新链表的第一个节点
            node.next = seconde;
            //node设置为下一个pair的前一个节点,即first，进行下一轮循环
            node = first;
        }
        return protect.next;
    }
}
