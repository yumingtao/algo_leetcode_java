package com.ymt.leetcode.list.lian_biao_zhong_dao_shu_di_kge_jie_dian_lcof;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description 使用栈
 * @author yumingtao
 * @date 2022-07-23 11:46
 */
public class Solution2 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        for (int i = 0; i < k - 1; ++i) {
            stack.pop();
        }
        return stack.isEmpty() ? null : stack.pop();
    }
}
