package com.ymt.leetcode.list.odd_even_linked_list;

/**
 * @description
 * @author yumingtao
 * @date 2022-07-31 19:31
 */
public class Solution1 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode odd = head;
        ListNode even = new ListNode(-1, head.next);
        ListNode t = even;
        while (odd.next != null) {
            //将偶数节点拼接到even
            t.next = odd.next;
            t = t.next;
            //删除原链表中的偶数节点
            odd.next = odd.next.next;
            //提前判断是否结束，防止拼接odd和even时空指针
            if (odd.next == null) {
                break;
            }
            odd = odd.next;
        }
        //防止循环
        t.next = null;
        //拼接odd和even
        odd.next = even.next;
        return dummy.next;
    }
}
