package com.ymt.leetcode.pre_sum.matrix_block_sum;

/**
 * 思路：
 * <p>
 * 先求出矩阵的前缀和sum，公式
 * sum(i,j)=sum(i-1,j) + sum(i,j-1) - sum[i-1,j-1] + nums[i,j]
 * <p>
 * 求下边范围矩阵的子矩阵和，可以使用下边公司求子矩阵和
 * 左上角(i-k, j-k) ~ 右下角(i+k, j+k)
 * 区间和 answer(i,j) = subSum(i-k,j-k,i+k,j+k) = sum(i+k,j+k) - sum(i+k,j-k-1) - sum(i-k-1,j+k) + sum(i-k-1,j-k-1)
 *
 * @author yumingtao
 * @date 2021/10/5 16:00
 */
public class Solution1 {
    int m;
    int n;
    int[][] sum;

    public int[][] matrixBlockSum(int[][] mat, int k) {
        m = mat.length;
        n = mat[0].length;

        //先求出矩阵前缀和
        sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        //计算子矩阵和
        int[][] answer = new int[m][n];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                answer[i - 1][j - 1] = getSum(i + k, j + k) - getSum(i + k, j - k - 1) - getSum(i - k - 1, j + k) + getSum(i - k - 1, j - k - 1);
            }
        }

        return answer;
    }

    private int getSum(int r, int c) {
        int i = getIndex(r, m);
        int j = getIndex(c, n);
        //int i = Math.max(Math.min(r, m), 0);
        //int j = Math.max(Math.min(c, n), 0);

        return sum[i][j];
    }

    private int getIndex(int index, int maxIndex) {
        if (index > maxIndex) {
            return maxIndex;
        } else if (index < 0) {
            return 0;
        }

        return index;
    }
}
