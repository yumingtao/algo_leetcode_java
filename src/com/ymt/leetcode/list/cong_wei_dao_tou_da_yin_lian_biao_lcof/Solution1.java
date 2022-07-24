package com.ymt.leetcode.list.cong_wei_dao_tou_da_yin_lian_biao_lcof;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description 使用栈
 * @author yumingtao
 * @date 2022-07-24 11:27
 */
public class Solution1 {
    public int[] reversePrint(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int i = 0;
        int[] ans = new int[stack.size()];
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop().val;
        }
        return ans;
    }
}
