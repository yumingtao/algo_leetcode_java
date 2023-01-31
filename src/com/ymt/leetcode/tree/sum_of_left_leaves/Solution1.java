package com.ymt.leetcode.tree.sum_of_left_leaves;

import com.ymt.leetcode.tree.TreeNode;

public class Solution1 {
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        travel(root, false);
        return sum;
    }

    private void travel(TreeNode root, boolean isLeft){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && isLeft){
            sum += root.val;
        }else{
            travel(root.left, true);
            travel(root.right, false);
        }
    }
}
