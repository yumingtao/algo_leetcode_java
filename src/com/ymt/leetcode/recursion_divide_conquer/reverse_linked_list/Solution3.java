package com.ymt.leetcode.recursion_divide_conquer.reverse_linked_list;

/**
 * @Description 使用递归
 * @author yumingtao
 * @date 2022/4/7 10:08
 */
public class Solution3 {
    public ListNode reverseList(ListNode head) {
        //递归终止条件
        if(head == null || head.next == null){
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newNode = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newNode;
    }
}
