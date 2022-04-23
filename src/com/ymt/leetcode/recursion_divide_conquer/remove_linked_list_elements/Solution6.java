package com.ymt.leetcode.recursion_divide_conquer.remove_linked_list_elements;

/**
 * @Description
 * @author yumingtao
 * @date 2022-04-23 15:14
 */
public class Solution6 {
    public ListNode removeElements(ListNode head, int val) {
        //递归终止条件
        if (head == null) {
            return head;
        }

        //进入下一层递归,把下一层的返回结果赋值给head.next
        head.next = removeElements(head.next, val);
        //判断head.val
        return head.val == val ? head.next : head;
    }
}
