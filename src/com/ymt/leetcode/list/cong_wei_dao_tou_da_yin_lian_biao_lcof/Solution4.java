package com.ymt.leetcode.list.cong_wei_dao_tou_da_yin_lian_biao_lcof;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description
 * @author yumingtao
 * @date 2022-07-24 12:00
 */
public class Solution4 {
    public int[] reversePrint(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        Collections.reverse(values);
        return values.stream().mapToInt(Integer::valueOf).toArray();
    }
}
