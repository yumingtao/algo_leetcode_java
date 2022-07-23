package com.ymt.leetcode.list.remove_duplicates_from_sorted_list;

import java.util.HashSet;
import java.util.Set;

/**
 * @description 使用Set
 * @author yumingtao
 * @date 2022-07-23 14:40
 */
public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> visited = new HashSet<>();
        ListNode curr = head;
        ListNode pre = new ListNode(-1, head);
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
