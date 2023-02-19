public class Solution1 {
    // 定义方向数组, 左、上、右、下
    private int[] dx = { -1, 0, 1, 0 };
    private int[] dy = { 0, 1, 0, -1 };
    private int ans = 0;
    private int m = 0;
    private int n = 0;
    private int[][] visited;

    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 找到一个没有遍历过的岛屿
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int i, int j) {
        visited[i][j] = 1;
        for (int k = 0; k < 4; ++k) {
            int x = i + dx[k];
            int y = j + dy[k];
            // 到达边界或是遇到水，加上边长后换个方向
            if ((x < 0 || x >= m || y < 0 || y >= n) || grid[x][y] == 0) {
                ++ans;
                continue;
            }
            // 访问过的不再访问
            if (visited[x][y] == 1) {
                continue;
            }
            dfs(grid, x, y);
        }
    }
}
