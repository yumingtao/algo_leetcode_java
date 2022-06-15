package com.ymt.leetcode.recursion_divide_conquer.reverse_linked_list_ii;

/**
 * @Description 参考题解采用头插法
 * @author yumingtao
 * @date 2022-05-03 17:33
 */
public class Solution4 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode protect = new ListNode(0);
        protect.next = head;
        //1.先找到left的前驱节点
        ListNode pre = protect;
        for (int i = 0; i < left - 1; ++i) {
            pre = pre.next;
        }

        //2.采用头插法，将遍历left后边的节点leftNext，将leftNext节点插入到pre的后边,注意left后边一用有right-left个节点需要移动
        ListNode leftNode = pre.next;
        ListNode leftNext;
        for (int i = 0; i < right - left; ++i) {
            leftNext = leftNode.next;
            //curNode指向下一轮要处理的节点
            leftNode.next = leftNext.next;
            //新的头节点要插入到当前头节点的前边，pre.next是当前的头节点
            leftNext.next = pre.next;
            //pre.next要一直指向新的头节点
            pre.next = leftNext;
        }

        return protect.next;
    }
}
