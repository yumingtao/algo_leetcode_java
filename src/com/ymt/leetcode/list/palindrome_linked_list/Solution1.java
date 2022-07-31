package com.ymt.leetcode.list.palindrome_linked_list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description
 * @author yumingtao
 * @date 2022-07-30 19:07
 */
public class Solution1 {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }

        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
}
