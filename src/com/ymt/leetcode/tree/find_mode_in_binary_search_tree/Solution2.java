package com.ymt.leetcode.tree.find_mode_in_binary_search_tree;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考题解
 */
public class Solution2 {
    private int currentCount = 0;
    private int maxCount = 0;
    private int last = 0;
    private List<Integer> ans = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        checkMax(root.val);
        dfs(root.right);
    }

    private void checkMax(int current) {
        if (current == last) {
            ++currentCount;
        } else {
            last = current;
            currentCount = 1;
        }
        if (currentCount == maxCount) {
            ans.add(current);
        } else if (currentCount > maxCount) {
            maxCount = currentCount;
            ans.clear();
            ans.add(current);
        }
    }
}