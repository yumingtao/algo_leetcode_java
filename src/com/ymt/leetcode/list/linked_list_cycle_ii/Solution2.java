package com.ymt.leetcode.list.linked_list_cycle_ii;

import java.util.HashSet;
import java.util.Set;

/**
 * @description
 * @author yumingtao
 * @date 2022-07-16 14:13
 */
public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            //因为是一步一步地走，遇到的第一个环中的点就是入环点
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
