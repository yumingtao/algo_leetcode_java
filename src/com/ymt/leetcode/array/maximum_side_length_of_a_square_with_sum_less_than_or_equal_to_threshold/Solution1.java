package com.ymt.leetcode.array.maximum_side_length_of_a_square_with_sum_less_than_or_equal_to_threshold;

/**
 * 思路：
 * 1.预处理矩阵前缀和
 * 2.从矩阵的某一点出发，二分查找有效边长edge找到<=threshold的最大子矩阵和
 * 3.计算最大正方形边长edge，ans=Math.max(ans, edge)，注意edge>=2才有效
 *
 * @author yumingtao
 * @date 2021/10/11 16:26
 */
public class Solution1 {
    private int m;
    private int n;

    public int maxSideLength(int[][] mat, int threshold) {
        m = mat.length;
        n = mat[0].length;

        //预处理，计算矩阵前缀和
        //pSum(i,j)=pSum[i-1][j]+pSum[i][j-1]-pSum[i-1][j-1]+nums(i,j)
        int[][] pSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pSum[i][j] = pSum[i - 1][j] + pSum[i][j - 1] - pSum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int ans = 0;
        //寻找满足条件的正方形
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //从(i,j)出发，能够获得的最大正方形边长，边长>=1
                int edge = Math.min(m - i, n - j);

                //如果边长是1，继续循环
                if (edge == 1) {
                    continue;
                }

                //二分查找子矩阵和<=threshold的最大边长
                int maxEdge = binarySearchEdge(pSum, i, j, edge, threshold);
                ans = maxEdge > 1 ? Math.max(ans, maxEdge) : ans;
            }
        }
        return ans;
    }

    private int binarySearchEdge(int[][] pSum, int i, int j, int edge, int target) {
        //注意边长的有效范围是1～edge，映射到坐标时需要-1
        int left = 1;
        int right = edge;
        while (left < right) {
            int mid = (left + right + 1) / 2;

            //计算从(i,j)~(i+mid-1, j+mid-1)的子矩阵和
            //公式sum(i,j,p,q)=pSum(p,q)-pSum(i-1,q)-pSum(p,j-1)+pSum(i-1,j-1)
            //注意，矩阵前缀和有效下标从1开始，而i和j是从0开始，所以要+1
            //i+1+mid-1 => i+mid, j+mid也是同样道理；i+1-1 => i, j+1-1 => j
            int subSum = pSum[i + mid][j + mid] - pSum[i][j + mid] - pSum[i + mid][j] + pSum[i][j];

            //寻找<=target的最大
            if (subSum <= target) {
                //解有可能还在右边
                left = mid;
            } else {
                //解一定在左边
                right = mid - 1;
            }
        }

        return right;
    }
}