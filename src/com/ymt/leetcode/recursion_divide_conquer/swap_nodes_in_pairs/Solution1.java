package com.ymt.leetcode.recursion_divide_conquer.swap_nodes_in_pairs;

/**
 * @Description 使用递归
 * @author yumingtao
 * @date 2022-04-23 15:46
 */
public class Solution1 {
    public ListNode swapPairs(ListNode head) {
        //递归终止条件, head==null说明链表中没有节点，head.val==null说明链表中只有一个节点
        if (head == null || head.next == null) {
            return head;
        }
        //原始链表的第二个节点会成为新的头节点
        ListNode newHead = head.next;
        //进入下一层递归,newHead.next是剩余链表的头节点
        //原始链表的head节点会成为新链表的第二个节点，它的next要指向后边剩余的新的头节点
        head.next = swapPairs(newHead.next);
        //建立新头节点和第二个节点的联系
        newHead.next = head;
        //返回新的头节点
        return newHead;
    }
}
