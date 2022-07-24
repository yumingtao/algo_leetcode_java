package com.ymt.leetcode.list.remove_duplicate_node_lcci;

import java.util.HashSet;
import java.util.Set;

/**
 * @description 使用Set
 * @author yumingtao
 * @date 2022-07-24 13:58
 */
public class Solution2 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(head.val);
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (visited.contains(curr.val)) {
                pre.next = curr.next;
            } else {
                visited.add(curr.val);
                pre = pre.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
