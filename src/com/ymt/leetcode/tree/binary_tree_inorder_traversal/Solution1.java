package com.ymt.leetcode.tree.binary_tree_inorder_traversal;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author yumingtao
 * @date 2023-01-08 15:40
 */
public class Solution1 {
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        travel(root);
        return ans;
    }

    private void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        travel(root.left);
        ans.add(root.val);
        travel(root.right);
    }
}

