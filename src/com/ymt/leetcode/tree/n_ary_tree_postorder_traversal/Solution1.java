package com.ymt.leetcode.tree.n_ary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;

import com.ymt.leetcode.tree.Node;

public class Solution1 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        travel(root);
        return ans;
    }

    private void travel(Node root){
        if(root == null){
            return;
        }
        for(Node node : root.children){
            travel(node);
        }
        ans.add(root.val);
    }
}
