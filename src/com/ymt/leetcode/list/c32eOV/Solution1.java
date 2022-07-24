package com.ymt.leetcode.list.c32eOV;

import java.util.HashSet;
import java.util.Set;

/**
 * @description 使用Set
 * @author yumingtao
 * @date 2022-07-24 14:47
 */
public class Solution1 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) {
                return head;
            }
            visited.add(head);
            head = head.next;
        }

        return null;
    }
}
