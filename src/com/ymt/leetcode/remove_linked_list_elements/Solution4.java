package com.ymt.leetcode.remove_linked_list_elements;

/**
 * @Description
 * @author yumingtao
 * @date 2022/4/19 13:40
 */
public class Solution4 {
    public ListNode removeElements(ListNode head, int val) {
        //排除头节点val等于val的情况
        while(head != null && head.val == val){
            head = head.next;
        }
        //此时head如果不是null，那么head.val一定不是val
        ListNode node = head;
        while(head != null && head.next != null){
            if(head.next.val == val){
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return node;
    }
}
