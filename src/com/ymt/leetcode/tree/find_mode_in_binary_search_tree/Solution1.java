package com.ymt.leetcode.tree.find_mode_in_binary_search_tree;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    private Map<Integer, Integer> frequency = new HashMap<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        List<Integer> ans = new ArrayList<>();
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                ans.clear();
                ans.add(entry.getKey());
            } else if (entry.getValue() == maxCount) {
                ans.add(entry.getKey());
            }
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        frequency.put(root.val, frequency.getOrDefault(root.val, 0) + 1);
        dfs(root.left);
        dfs(root.right);
    }
}