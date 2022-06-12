package com.ymt.leetcode.pre_sum.largest_magic_square;

/**
 * @author yumingtao
 * @date 2021/10/10 18:23
 */
public class Solution1 {
    int m;
    int n;
    int[][] rowSum;
    int[][] colSum;

    public int largestMagicSquare(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        rowSum = new int[m][n + 1];
        colSum = new int[n][m + 1];

        //预处理每一行的前缀和，注意索引从1开始
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                rowSum[i][j] = rowSum[i][j - 1] + grid[i][j - 1];
            }
            //System.out.println(Arrays.stream(rowSum[i]).boxed().collect(Collectors.toList()));
        }


        //预处理每一列的前缀和，注意索引从1开始
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                colSum[i][j] = colSum[i][j - 1] + grid[j - 1][i];
            }
            //System.out.println(Arrays.stream(colSum[i]).boxed().collect(Collectors.toList()));
        }

        //必有的解是1
        int ans = 1;
        //遍历矩阵枚举每个正方形
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int edgeLength = getValidEdgeLength(i, j);
                //System.out.println("i:" + i + ",j:" + j + ",edge:" + edgeLength);
                //变长是1的正方形不需要判断，最大幻方的尺寸就是1
                if (edgeLength == 1) {
                    continue;
                }

                //判断当前点扩散出去的所有正方形是否满足
                //l表示边的长度, 长度从2到edgeLength
                for (int l = 2; l <= edgeLength; l++) {
                    if (isValid(grid, i, j, l)) {
                        ans = Math.max(ans, l);
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 计算每个正方形是否满足条件
     * @param grid
     * @param i
     * @param j
     * @param edgeLength
     * @return
     */
    private boolean isValid(int[][] grid, int i, int j, int edgeLength) {
        //System.out.println("i:" + i + ",j:" + j + ",edge:" + edgeLength);
        //以(i,j)为起点，计算两个对角线之和
        int lSum = 0;
        int rSum = 0;
        for (int l = 0; l < edgeLength; l++) {
            //左上右下对角线
            lSum += grid[i + l][j + l];
            //因为边长是edgeLength，所以转换成索引的范围是0~edgeLength-1
            //j+edgeLength-1表示当前最大的列索引，再减去l即是右上左下的对角线
            rSum += grid[i + l][j + edgeLength - 1 - l];
        }

        //System.out.println("lSum:" + lSum + ", rSum:" + rSum);
        //判断两条对角线是否相等
        if (lSum != rSum) {
            return false;
        }

        //判断每一行或列是否相等, 判断是否等于lSum或rSum
        for (int l = 0; l < edgeLength; l++) {
            //判断行，计算行的区间和是否等于lSum或rSum
            //因为j是从0开始，列区间和索引范围应该是从j+1～j+1+edgeLength-l，即j+1～j+edgeLength
            //所以列的区间和是rowSum[i + l][j + edgeLength] - rowSum[i + l][j]
            int rowLength = rowSum[i + l][j + edgeLength] - rowSum[i + l][j];
            //System.out.println("rowLen:" + rowLength);
            if (lSum != rowLength) {
                return false;
            }

            //判断列，计算列的区间和是否等于lSum或rSum
            //因为i是从0开始，行区间和索引范围应该是从i+1～i+1+edgeLength-l，即i+1～i+edgeLength
            //所以列的区间和是rowSum[j + l][i + edgeLength] - rowSum[j + l][i]
            int colLength = colSum[j + l][i + edgeLength] - colSum[j + l][i];
            //System.out.println("colLen:" + colLength);
            if (lSum != colLength) {
                return false;
            }
        }

        return true;
    }

    /**
     * 根据当前(i,j)，计算该点允许扩散出去的正方形最大边长
     * @param i
     * @param j
     * @return
     */
    private int getValidEdgeLength(int i, int j) {
        return Math.min(m - i, n - j);
    }
}
