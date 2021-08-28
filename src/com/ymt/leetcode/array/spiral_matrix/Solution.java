package com.ymt.leetcode.array.spiral_matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yumingtao
 * @date 2021/8/28 11:03
 */
public class Solution {
    private int[] dx = {-1, 0, 0, 1};
    private int[] dy = {0, 1, -1, 0};
    private int m;
    private int n;
    private boolean[][] visited;
    private List<Integer> ans;

    public List<Integer> spiralOrder(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        visited = new boolean[m][n];
        ans = new ArrayList<>();

        visited[0][0] = true;
        ans.add(matrix[0][0]);

        //初始方向只能向右，找到第一个改变方向的点
        //根据方向数组dx，dy的定义，dx[1]和dy[1]代表向右移动，即dir=1
        Queue<int[]> q = new LinkedList<>();
        int[] first = getNext(matrix, 0, 0, 1);
        q.add(first);

        //bfs
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            //遍历四个方向出边
            for (int k = 0; k < 4; k++) {
                //往一个方向走，直到走不动后，返回改变方向的点行列下标
                int[] next = getNext(matrix, x, y, k);

                //如果该点行列坐标与当前点cur相同，说明该方向不能继续移动
                //否则说明已经走到下一个改变方向的点，将该点添加得到队列
                if (!(next[0] == x && next[1] == y)) {
                    q.add(next);
                }
            }
        }

        return ans;
    }

    private int[] getNext(int[][] matrix, int x, int y, int dir) {
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            //在当前方向上遇到边界或是该点访问过，不能向前移动，退出循环
            if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) {
                break;
            }

            //将该点添加到访问路径上，并标记为已访问，继续向同一个方向前进
            ans.add(matrix[nx][ny]);
            visited[nx][ny] = true;
            x = nx;
            y = ny;
        }

        //返回最后可以到达的点
        //注意有可能是当前点，说明当前dir方向上，不能继续前进
        return new int[]{x, y};
    }
}
