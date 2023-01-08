package com.ymt.leetcode.tree.same_tree;

import com.ymt.leetcode.tree.TreeNode;

/**
 * @description
 * @author yumingtao
 * @date 2023-01-08 17:28
 */
public class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
