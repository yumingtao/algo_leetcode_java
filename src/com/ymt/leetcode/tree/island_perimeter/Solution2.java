package com.ymt.leetcode.tree.island_perimeter;

/**
 * 参考题解
 */
public class Solution2 {
    //定义方向数组, 左、上、右、下
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int m = 0;
    private int n = 0;

    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                //找到一个没有遍历过的岛屿
                if (grid[i][j] == 1) {
                    ans += dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        //到达边界或是遇到水，加上边长后换个方向
        if ((i < 0 || i >= m || j < 0 || j >= n) || grid[i][j] == 0) {
            return 1;
        }
        //访问过的不再访问
        if (grid[i][j] == 2) {
            return 0;
        }
        grid[i][j] = 2;
        int res = 0;
        for (int k = 0; k < 4; ++k) {
            int x = i + dx[k];
            int y = j + dy[k];
            res += dfs(grid, x, y);
        }
        return res;
    }
}