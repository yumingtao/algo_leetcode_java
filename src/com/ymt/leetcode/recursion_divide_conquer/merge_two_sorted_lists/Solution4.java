package com.ymt.leetcode.recursion_divide_conquer.merge_two_sorted_lists;

/**
 * @Description 使用递归
 * @author yumingtao
 * @date 2022/4/6 11:40
 */
public class Solution4 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode();
        merge(l1, l2, newList);
        return newList.next;
    }

    private void merge(ListNode l1, ListNode l2, ListNode newList) {
        //递归终止条件
        if (l1 == null) {
            newList.next = l2;
            return;
        } else if (l2 == null) {
            newList.next = l1;
            return;
        }

        //处理逻辑
        if (l1.val <= l2.val) {
            newList.next = l1;
            l1 = l1.next;
        } else {
            newList.next = l2;
            l2 = l2.next;
        }

        //进入下一层
        merge(l1, l2, newList.next);
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
