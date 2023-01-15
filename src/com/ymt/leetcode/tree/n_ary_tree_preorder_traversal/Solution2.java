package com.ymt.leetcode.tree.n_ary_tree_preorder_traversal;

import com.ymt.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 迭代，利用栈后进先出
 */
public class Solution2 {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null) {
                ans.add(node.val);
                int size = node.children.size();
                for (int i = size - 1; i >= 0; --i) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return ans;
    }
}