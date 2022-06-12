package com.ymt.leetcode.recursion_divide_conquer.remove_linked_list_elements;

/**
 * @Description 使用迭代
 * @author yumingtao
 * @date 2022/4/19 09:47
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode node = pre;
        while (node.next != null){
            if(node.next.val == val){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        return pre.next;
    }
}
