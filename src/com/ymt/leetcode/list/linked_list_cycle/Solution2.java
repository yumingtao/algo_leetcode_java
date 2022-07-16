package com.ymt.leetcode.list.linked_list_cycle;

import java.util.HashSet;
import java.util.Set;

/**
 * @description
 * @author yumingtao
 * @date 2022-07-16 12:14
 */
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
