package com.ymt.leetcode.tree.sum_of_left_leaves;

import com.ymt.leetcode.tree.TreeNode;

public class Solution2 {
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        return root == null ? 0 : travel(root);
    }

    private int travel(TreeNode root){
       int ans = 0;
       if(root.left != null){
           if(isLeaf(root.left)){
                ans += root.left.val;
           }else{
                ans += travel(root.left);
           }
       }

       if(root.right != null){
           if(!isLeaf(root.right)){
               ans += travel(root.right);
           }
       }
       return ans;
    }

    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}
