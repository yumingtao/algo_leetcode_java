package com.ymt.leetcode.recursion_divide_conquer.reorder_list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @author yumingtao
 * @date 2022-04-23 19:42
 */
public class Solution1 {
    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }

        int size = nodes.size();
        int count = size / 2;
        for (int i = 0; i < count; ++i) {
            ListNode node = nodes.get(i);
            node.next = nodes.get(size - i - 1);
            node.next.next = nodes.get(i + 1);
        }
        //防止出现环,最后的nodes.get(i+1).next设置为null，无论奇数个还是偶数个节点，循环结束后的第i+1个节点索引是count
        nodes.get(count).next = null;
    }
}
