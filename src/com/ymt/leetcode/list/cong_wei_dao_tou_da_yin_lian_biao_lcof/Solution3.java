package com.ymt.leetcode.list.cong_wei_dao_tou_da_yin_lian_biao_lcof;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author yumingtao 使用List
 * @date 2022-07-24 11:39
 */
public class Solution3 {
    public int[] reversePrint(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        int size = values.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; ++i) {
            ans[i] = values.get(size - i - 1);
        }
        return ans;
    }
}
