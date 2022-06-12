package com.ymt.leetcode.recursion_divide_conquer.merge_two_sorted_lists;

/**
 * @Description 使用递归
 * @author yumingtao
 * @date 2022/4/6 09:39
 */
public class Solution3 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //递归终止条件
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        //处理逻辑
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
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
