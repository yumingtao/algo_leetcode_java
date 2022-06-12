package com.ymt.leetcode.recursion_divide_conquer.reverse_linked_list;

/**
 * @Description Solution1简单优化
 * @author yumingtao
 * @date 2022/4/7 09:29
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode curNext;
        while (head != null) {
            curNext = head.next;
            head.next = last;
            last = head;
            head = curNext;
        }
        return last;
    }
}
