package com.ymt.leetcode.tree.symmetric_tree;

import com.ymt.leetcode.tree.TreeNode;

/**
 * @author yumingtao
 * @description 迭代 DFS
 * @date 2023-05-28 14:26
 */
public class Solution1 {
    private final StringBuilder leftSb = new StringBuilder();
    private final StringBuilder rightSb = new StringBuilder();
    public boolean isSymmetric(TreeNode root) {
        travelPreorder(root.left);
        travelReversePreorder(root.right);
        return leftSb.toString().contentEquals(rightSb);
    }

    private void travelPreorder(TreeNode root){
        if(root == null){
            leftSb.append("-");
            return;
        }
        leftSb.append(root.val);
        travelPreorder(root.left);
        travelPreorder(root.right);
    }

    private void travelReversePreorder(TreeNode root){
        if(root == null){
            rightSb.append("-");
            return;
        }
        rightSb.append(root.val);
        travelReversePreorder(root.right);
        travelReversePreorder(root.left);
    }
}
