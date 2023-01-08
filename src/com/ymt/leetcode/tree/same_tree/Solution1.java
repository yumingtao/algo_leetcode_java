package com.ymt.leetcode.tree.same_tree;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author yumingtao
 * @date 2023-01-08 16:59
 */
public class Solution1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> preOrderP = new ArrayList<>();
        List<Integer> preOrderQ = new ArrayList<>();
        preOrderTravel(p, preOrderP);
        preOrderTravel(q, preOrderQ);
        return preOrderP.equals(preOrderQ);
    }

    private void preOrderTravel(TreeNode root, List<Integer> preOrderVal) {
        if (root == null) {
            preOrderVal.add(null);
            return;
        }
        preOrderVal.add(root.val);
        preOrderTravel(root.left, preOrderVal);
        preOrderTravel(root.right, preOrderVal);
    }
}
