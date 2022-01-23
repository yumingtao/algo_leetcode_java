package com.ymt.leetcode.two_pointers.remove_nth_node_from_end_of_list;

/**
 * @Description Solution1优化
 * @author yumingtao
 * @date 2022-01-22 22:08
 */
public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            ++count;
            cur = cur.next;
        }
        //判断删除第一个节点的情况
        if (count == n) {
            return head.next;
        }
        //计算删除节点位置，从0开始
        int target = count - n;
        ListNode pre = head;
        while (target > 1 && head != null) {
            --target;
            head = head.next;
        }
        //找到目标节点的前一个节点
        if(head.next != null) {
            head.next = head.next.next;
        }
        return pre;
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
