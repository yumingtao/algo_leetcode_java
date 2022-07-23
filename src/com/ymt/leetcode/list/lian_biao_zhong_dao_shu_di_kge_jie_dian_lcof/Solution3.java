package com.ymt.leetcode.list.lian_biao_zhong_dao_shu_di_kge_jie_dian_lcof;

/**
 * @description 使用双指针
 * @author yumingtao
 * @date 2022-07-23 11:56
 */
public class Solution3 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        ListNode seconde = head;
        for (int i = 0; i < k; ++i) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            seconde = seconde.next;
        }

        return seconde;
    }
}
