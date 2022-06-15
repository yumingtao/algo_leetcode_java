package com.ymt.leetcode.recursion_divide_conquer.reverse_linked_list_ii;

/**
 * @Description 参考题解实现
 * @author yumingtao
 * @date 2022-05-03 16:28
 */
public class Solution3 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode protect = new ListNode(0);
        protect.next = head;
        ListNode leftPre = protect;
        //1.先从protect开始先后走left-1步，找到left的前驱
        for (int i = 0; i < left - 1; ++i) {
            leftPre = leftPre.next;
        }
        //2.再从leftPre走right-left+1步，找到right节点
        ListNode rightNode = leftPre;
        for (int i = 0; i < right - left + 1; ++i) {
            rightNode = rightNode.next;
        }

        //3.得到left节点和right的后继节点
        ListNode leftNode = leftPre.next;
        ListNode rightNext = rightNode.next;

        //4.切断原指向联系, 截取出对立的[left,right]区间的链表
        leftPre.next = null;
        rightNode.next = null;

        //5.翻转[left,right]的链表
        reverseList(leftNode);

        //6.将翻转后的[left,right]链表拼接回来
        leftPre.next = rightNode;
        leftNode.next = rightNext;
        return protect.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curNext = head.next;
        ListNode newHead = reverseList(curNext);
        curNext.next = head;
        head.next = null;
        return newHead;
    }
}
