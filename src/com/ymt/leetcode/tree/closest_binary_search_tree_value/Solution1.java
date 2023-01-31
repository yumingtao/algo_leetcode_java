package com.ymt.leetcode.tree.closest_binary_search_tree_value;

import com.ymt.leetcode.tree.TreeNode;

public class Solution1 {
    int ans = 0;
    Double minDiff = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        travel(root, target);
        return ans;
    }

    private void travel(TreeNode root, double target){
        if(root == null){
            return;
        }
        Double currDiff = Math.abs(root.val - target);
        if(minDiff.compareTo(currDiff) > 0){
            minDiff = currDiff;
            ans = root.val;
        }
        travel(root.left, target);
        travel(root.right, target);
    }
}
