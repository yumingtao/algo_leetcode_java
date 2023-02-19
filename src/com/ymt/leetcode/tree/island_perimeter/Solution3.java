/**
 * 参考题解，纯迭代
 */
public class Solution3 {
    // 定义方向数组, 左、上、右、下
    private int[] dx = { -1, 0, 1, 0 };
    private int[] dy = { 0, 1, 0, -1 };

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 找到一个没有遍历过的岛屿
                if (grid[i][j] == 1) {
                    int res = 0;
                    for (int k = 0; k < 4; ++k) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        // 到达边界或是遇到水，加上边长后换个方向
                        if ((x < 0 || x >= m || y < 0 || y >= n) || grid[x][y] == 0) {
                            ++res;
                        }
                    }
                    ans += res;
                }
            }
        }
        return ans;
    }
}
