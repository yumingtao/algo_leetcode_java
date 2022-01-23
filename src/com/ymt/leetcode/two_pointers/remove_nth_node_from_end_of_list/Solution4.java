package com.ymt.leetcode.two_pointers.remove_nth_node_from_end_of_list;

/**
 * @Description 题解：快慢指针
 * @author yumingtao
 * @date 2022-01-23 10:47
 */
public class Solution4 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //链表中节点数至少为1，所以不用判断head=null的情况
        //先设置一个保护节点
        ListNode pre = new ListNode(0, head);
        //fast先向前走n步
        ListNode fast = head;
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }

        //让慢指针指向pre，fast和slow同时移动，直到fast为null，此时slow指向的是倒数第n个节点的前驱节点
        //注意如果slow也指向head的话，当fast为null时，得到的刚好是倒数第n个节点，但是我们需要找到的是倒数第n个节点的前驱节点
        ListNode slow = pre;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return pre.next;
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
