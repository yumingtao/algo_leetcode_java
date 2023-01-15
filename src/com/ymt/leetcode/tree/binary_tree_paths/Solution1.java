package com.ymt.leetcode.tree.binary_tree_paths;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        travel(root, new StringBuilder());
        return ans;
    }

    private void travel(TreeNode root, StringBuilder sb){
        if(root == null){
            return;
        }
        StringBuilder currSb = new StringBuilder(sb.toString()).append(root.val);
        if(root.left == null && root.right == null){
            ans.add(currSb.toString());
        }else{
            currSb.append("->");
            travel(root.left, currSb);
            travel(root.right, currSb);
        }
    }
}