package com.ymt.leetcode.two_pointers.remove_nth_node_from_end_of_list;

/**
 * @Description
 * @author yumingtao
 * @date 2022-01-22 21:12
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //先统计节点数
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            ++count;
            cur = cur.next;
        }
        //判断删除第一个节点的情况
        if (count == n) {
            return head.next;
        }
        //计算删除第几个节点
        int target = count - n;
        ListNode pre = head;
        while (head != null) {
            //找到目标节点的前一个节点
            if (target == 1) {
                if (head.next != null) {
                    head.next = head.next.next;
                }
                break;
            }
            --target;
            head = head.next;
        }
        return pre;
    }

    public class ListNode {
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
