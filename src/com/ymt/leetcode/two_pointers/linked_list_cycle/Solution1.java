package com.ymt.leetcode.two_pointers.linked_list_cycle;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 使用set
 *
 * @author yumingtao
 * @date 2022-01-22 20:37
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head.next != null){
            if(set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
}
