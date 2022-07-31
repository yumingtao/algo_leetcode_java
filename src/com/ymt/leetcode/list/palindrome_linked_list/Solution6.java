package com.ymt.leetcode.list.palindrome_linked_list;

/**
 * @description 题解快慢指针
 * @author yumingtao
 * @date 2022-07-31 15:02
 */
public class Solution6 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //快慢指针找到前半部分的结束节点，其下一个节点位后半部分的起始节点
        ListNode firstHalfEnd = getHalfStart(head);
        //反转后半部分
        ListNode secondHalfReverseStart = reverseList(firstHalfEnd.next);
        //逐个比较前半部分和后半部分
        boolean ret = compare(head, secondHalfReverseStart);
        //反转还原后半部分
        firstHalfEnd.next = reverseList(secondHalfReverseStart);
        return ret;
    }

    private boolean compare(ListNode p1, ListNode p2) {
        while (p2 != null) {
            if (p1.val == p2.val) {
                p1 = p1.next;
                p2 = p2.next;
            } else {
                return false;
            }
        }
        return true;
    }

    //快慢指针获取前半部分的结束节点
    //1 2 2 1，偶数时，慢指针所在节点的下一个节点即后半部分的起始节点
    //1 2 1 2 1, 奇数时，慢指针所在节点的下一个节点是后半部分的起始节点
    private ListNode getHalfStart(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode t = head.next;
            head.next = newHead;
            newHead = head;
            head = t;
        }
        return newHead;
    }
}
