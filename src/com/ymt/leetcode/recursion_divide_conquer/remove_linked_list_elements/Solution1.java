package com.ymt.leetcode.recursion_divide_conquer.remove_linked_list_elements;

/**
 * @Description 使用递归
 * 1. 递归先找到最后一个节点
 * @author yumingtao
 * @date 2022-04-18 20:11
 */
public class Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        //递归终止条件
        if(head == null){
            return null;
        }

        //进入下一层递归
        head.next = removeElements(head.next, val);
        //判断当前head的val是否和给定val相等，相等则返回head的下一个节点，否则返回改节点
        return head.val == val ? head.next : head;
    }
}
