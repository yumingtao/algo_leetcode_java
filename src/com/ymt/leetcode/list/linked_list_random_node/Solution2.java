package com.ymt.leetcode.list.linked_list_random_node;

import java.util.Random;

/**
 * @description 题解实现
 * @author yumingtao
 * @date 2022-08-27 17:05
 */
public class Solution2 {
    private Random random;
    private ListNode head;

    public Solution2(ListNode head) {
        random = new Random();
        this.head = head;
    }

    public int getRandom() {
        int i = 1;
        int ans = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (random.nextInt(i) == 0) {
                ans = cur.val;
            }
            ++i;
        }
        return ans;
    }
}
