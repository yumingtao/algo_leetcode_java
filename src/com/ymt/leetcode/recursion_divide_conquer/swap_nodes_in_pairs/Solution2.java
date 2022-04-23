package com.ymt.leetcode.recursion_divide_conquer.swap_nodes_in_pairs;

/**
 * @Description 递归
 * @author yumingtao
 * @date 2022-04-23 16:58
 */
public class Solution2 {
    public ListNode swapPairs(ListNode head) {
        //递归终止条件，head==null说明是空，head.next==null说明只有一个节点，不能构成pair，直接返回这一个节点
        if (head == null || head.next == null) {
            return head;
        }
        //newHead是新的头节点，做为下一层递归的头节点
        ListNode newHead = head.next;
        //交换后head是当前pair的第二个节点，指向下一个pair的头节点，下一个pair的头节点是head.next.next即newHead
        head.next = swapPairs(newHead.next);
        //当前pair重新建立联系，即pair的第一个节点指向pair的第二个节点
        newHead.next = head;
        //返回新的头节点
        return newHead;
    }
}
