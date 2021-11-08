package com.ymt.leetcode.pre_sum.maximum_side_length_of_a_square_with_sum_less_than_or_equal_to_threshold;

/**
 * 思路：暴力枚举正方形+优化
 * 1.在遍历矩阵前缀和枚举正方形时，如果找到了边长l的正方形满足条件
 * 2.在i++或j++时，就可以忽略所有边长小于等于l的正方形，从而优化枚举
 *
 * @author yumingtao
 * @date 2021/10/13 17:20
 */
public class Solution3 {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        //预处理矩阵前缀和
        //公式pSum(i,j)=pSum(i-1,j)+pSum(i,j-1)-pSum(i-1,j-1)+mat(i,j)
        int[][] pSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pSum[i][j] = pSum[i - 1][j] + pSum[i][j - 1] - pSum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int ans = 0;
        int maxLength = Math.min(m, n);
        //遍历矩阵前缀和，以(i,j)为左上角，(i+l-1,j+l-1)为右下角，枚举正方形
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //边长从ans+1开始，忽略所有边长小于ans的正方形
                for (int l = ans + 1; l <= maxLength; l++) {
                    //如果下标超出边界，直接break
                    if (i + l - 1 > m || j + l - 1 > n) {
                        break;
                    }
                    //计算子矩阵和
                    //公式sum(x1,y1,x2,y2)=pSum(x2,y2)-pSum(x1-1,y2)-p(x2,y1-1)+pSum(x1-1,y1-1)
                    //x1=i,y1=j,x2=i+l-1,y2=j+l-1
                    int area = pSum[i + l - 1][j + l - 1] - pSum[i - 1][j + l - 1]
                            - pSum[i + l - 1][j - 1] + pSum[i - 1][j - 1];
                    //l增加，子矩阵和也增加，所以后边没必要计算，直接break
                    if (area > threshold) {
                        break;
                    }
                    ans++;
                }
            }
        }

        return ans;
    }
}
