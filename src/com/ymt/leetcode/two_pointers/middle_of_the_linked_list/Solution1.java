package com.ymt.leetcode.two_pointers.middle_of_the_linked_list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 使用List
 * @author yumingtao
 * @date 2022-01-23 14:19
 */
public class Solution1 {
    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        int count = 0;
        while (head != null) {
            ++count;
            list.add(head);
            head = head.next;
        }
        int target = count / 2 + 1;
        return list.get(target - 1);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
