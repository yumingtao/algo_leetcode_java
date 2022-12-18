package com.ymt.leetcode.tree.binary_tree_postorder_traversal;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author yumingtao
 * @date 2023-01-08 15:57
 */
public class Solution1 {
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        travel(root);
        return ans;
    }

    private void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        travel(root.left);
        travel(root.right);
        ans.add(root.val);
    }
}
