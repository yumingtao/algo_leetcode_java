package com.ymt.leetcode.recursion_divide_conquer.reverse_linked_list_ii;

/**
 * @Description
 * @author yumingtao
 * @date 2022-05-03 16:13
 */
public class Solution2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode protect = new ListNode(0);
        protect.next = head;
        //1.找到left的pre, right的next
        int index = 1;
        //如果left=1，设置leftPre为protect
        ListNode leftPre = protect;
        ListNode rightNext = null;
        while(head != null){
            if(index == left - 1){
                leftPre = head;
            }
            head = head.next;
            if(index == right){
                rightNext = head;
                break;
            }
            ++index;
        }
        //2.反转[left,right]
        ListNode curNode = leftPre.next;
        //翻转时，当前节点会重新指向它的前驱节点，而left节点在翻转之后，会成为新的right节点，让它指向rightNext
        ListNode curPre = rightNext;
        ListNode curNext;
        while(curNode != rightNext){
            curNext = curNode.next;
            //翻转，之前它的前驱
            curNode.next = curPre;
            curPre = curNode;
            curNode = curNext;
        }
        //3.[left,right]反转后,leftPre指向新的left即原来的right节点,此时curPre刚好是原来的right节点
        leftPre.next = curPre;

        return protect.next;
    }
}
