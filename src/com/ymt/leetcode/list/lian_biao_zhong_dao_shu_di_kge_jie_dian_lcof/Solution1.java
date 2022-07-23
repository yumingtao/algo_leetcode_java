package com.ymt.leetcode.list.lian_biao_zhong_dao_shu_di_kge_jie_dian_lcof;

/**
 * @description 使用迭代
 * @author yumingtao
 * @date 2022-07-23 11:36
 */
public class Solution1 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            ++len;
            node = node.next;
        }
        for (int i = 0; i < len - k; ++i) {
            head = head.next;
        }
        return head;
    }
}
