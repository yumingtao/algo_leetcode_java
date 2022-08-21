package com.ymt.leetcode.list.copy_list_with_random_pointer;

/**
 * @description
 * @author yumingtao
 * @date 2022-08-21 13:04
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
