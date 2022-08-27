package com.ymt.leetcode.list.linked_list_random_node;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @description
 * @author yumingtao
 * @date 2022-08-27 16:22
 */
public class Solution1 {
    private Random random;
    private Map<Integer, ListNode> cachedNodes;
    private int n = 0;

    public Solution1(ListNode head) {
        random = new Random();
        cachedNodes = new HashMap<>();
        int i = 0;
        while (head != null) {
            cachedNodes.put(i++, head);
            head = head.next;
        }
        n = cachedNodes.size();
    }

    public int getRandom() {
        int key = random.nextInt(n);
        return cachedNodes.get(key).val;
    }
}
