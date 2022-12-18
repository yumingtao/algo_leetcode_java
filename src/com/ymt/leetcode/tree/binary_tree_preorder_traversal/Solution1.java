package com.ymt.leetcode.tree.binary_tree_preorder_traversal;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author yumingtao
 * @date 2023-01-08 15:49
 */
public class Solution1 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        travel(root);
        return ans;
    }

    private void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        travel(root.left);
        travel(root.right);
    }
}
