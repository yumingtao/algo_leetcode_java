package com.ymt.leetcode.list.remove_duplicate_node_lcci;

import java.util.HashSet;
import java.util.Set;

/**
 * @description 使用HashSet
 * @author yumingtao
 * @date 2022-07-24 13:54
 */
public class Solution1 {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> visited = new HashSet<>();
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode curr = head;
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
