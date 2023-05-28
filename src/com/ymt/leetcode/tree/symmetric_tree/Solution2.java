package com.ymt.leetcode.tree.symmetric_tree;

import com.ymt.leetcode.tree.TreeNode;

/**
 * @author yumingtao
 * @description 递归
 * @date 2023-05-28 15:07
 */
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}
