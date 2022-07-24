package com.ymt.leetcode.list.cong_wei_dao_tou_da_yin_lian_biao_lcof;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description
 * @author yumingtao
 * @date 2022-07-24 11:34
 */
public class Solution2 {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int i = 0;
        int[] ans = new int[stack.size()];
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        return ans;
    }
}
