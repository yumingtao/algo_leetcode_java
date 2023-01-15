package com.ymt.leetcode.tree.n_ary_tree_preorder_traversal;

import com.ymt.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    private List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        travel(root);
        return ans;
    }

    private void travel(Node root){
        if(root == null){
            return;
        }
        ans.add(root.val);
        for(Node node : root.children){
            travel(node);
        }
    }
}