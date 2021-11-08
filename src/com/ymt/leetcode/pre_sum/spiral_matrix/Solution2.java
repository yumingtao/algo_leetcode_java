package com.ymt.leetcode.pre_sum.spiral_matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yumingtao
 * @date 2021/8/28 11:56
 */
public class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        //模拟顺时针方向
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        List<Integer> ans = new ArrayList<>();

        visited[0][0] = true;
        ans.add(matrix[0][0]);
        int total = m * n;

        int nx = 0;
        int ny = 0;
        //初始方向向右
        int dir = 0;
        while (ans.size() < total) {
            nx += dx[dir];
            ny += dy[dir];

            //到达了边界，或是走到了已经访问过的点，需要改变方向
            if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) {
                //退回一步
                nx -= dx[dir];
                ny -= dy[dir];
                //改变方向
                dir = (dir + 1) % 4;
            } else {
                //标记已访问，并加入ans
                visited[nx][ny] = true;
                ans.add(matrix[nx][ny]);
            }
        }

        return ans;
    }
}
