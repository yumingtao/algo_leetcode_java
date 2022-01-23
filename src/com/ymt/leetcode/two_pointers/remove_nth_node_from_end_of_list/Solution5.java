package com.ymt.leetcode.two_pointers.remove_nth_node_from_end_of_list;

import java.util.Stack;

/**
 * @Description 题解：使用栈
 * @author yumingtao
 * @date 2022-01-23 11:11
 */
public class Solution5 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //设置保护节点
        ListNode pre = new ListNode(0, head);
        //遍历链表，压栈
        Stack<ListNode> stack = new Stack<>();
        //注意从pre开始压栈，防止最后弹出null
        ListNode cur = pre;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //出栈，直到弹出第n+1个，是倒数第n个节点的前驱节点
        for (int i = 0; i < n + 1; ++i) {
            cur = stack.pop();
        }
        cur.next = cur.next.next;
        return pre.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
