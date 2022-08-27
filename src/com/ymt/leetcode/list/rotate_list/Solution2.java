package com.ymt.leetcode.list.rotate_list;

/**
 * @description 题解
 * @author yumingtao
 * @date 2022-08-27 16:06
 */
public class Solution2 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        //计算链表长度
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            ++len;
            cur = cur.next;
        }
        //如果k是链表的长度的整数倍，直接返回head
        if (k % len == 0) {
            return head;
        }
        //此时cur为链表的最后一个节点，让其与head节点相连，形成环
        cur.next = head;
        //找到移动后链表的最后一个节点，应该是第len-1-k%len
        for (int i = 0; i < len - 1 - k % len; ++i) {
            head = head.next;
        }

        //最后一个节点的next是新节点的头
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }
}
