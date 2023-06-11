package com.ymt.leetcode.tree.balanced_binary_tree;

import com.ymt.leetcode.tree.TreeNode;

public class Solution1 {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftHeight = calculateNodeHeight(root.left);
        int rightHeight = calculateNodeHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int calculateNodeHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = calculateNodeHeight(root.left);
        int rightHeight = calculateNodeHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}