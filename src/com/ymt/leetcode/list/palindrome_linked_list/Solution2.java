package com.ymt.leetcode.list.palindrome_linked_list;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author yumingtao
 * @date 2022-07-30 19:16
 */
public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        int first = 0;
        int last = values.size() - 1;
        while (first < last) {
            if (!values.get(first++).equals(values.get(--last))) {
                return false;
            }
        }
        return true;
    }
}
