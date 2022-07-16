package com.ymt.leetcode.list.linked_list_cycle;

/**
 * @description 使用双指针
 * @author yumingtao
 * @date 2022-07-16 12:13
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        //链表中有0个或1个节点，直接返回false
        if(head == null || head.next == null){
            return false;
        }
        //快指针每次走2步
        ListNode fast = head.next.next;
        //慢指针每次走1步
        ListNode slow = head.next;
        while(fast != null && fast.next != null){
            //注意此处不是比较val
            if(fast== slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
