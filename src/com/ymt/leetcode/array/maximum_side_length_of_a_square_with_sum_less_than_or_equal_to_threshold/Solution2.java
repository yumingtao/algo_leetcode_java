package com.ymt.leetcode.array.maximum_side_length_of_a_square_with_sum_less_than_or_equal_to_threshold;

/**
 * 思路：
 * 1.边长下界为1，上界为min(m,n)，
 * 2.如果边长l满足条件，那么在边长l的正方形內的正方形都满足条件
 * 3.可以使用二分查找枚举边长l，然后枚举边长l的正方形是否满足条件
 *
 * @author yumingtao
 * @date 2021/10/13 17:20
 */
public class Solution2 {
    private int m;
    private int n;

    public int maxSideLength(int[][] mat, int threshold) {
        m = mat.length;
        n = mat[0].length;

        //预处理矩阵前缀和
        //公式pSum(i,j)=pSum(i-1,j)+pSum(i,j-1)-pSum(i-1,j-1)+mat(i,j)
        int[][] pSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pSum[i][j] = pSum[i - 1][j] + pSum[i][j - 1] - pSum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int ans = 0;
        //边长范围1～min(m,n)，注意二分查找边长时left设置为0
        int left = 0;
        int right = Math.min(m, n);

        //终止于left==right
        while (left < right) {
            //此处要+1，因为left=mid
            int mid = (left + right + 1) / 2;
            boolean found = false;
            //注意此处是循环遍历矩阵和，下标从1开始，开始枚举是否边长为mid的正方形是否满足条件
            //保证i,j在pSum的下标(m+1，n+1)范围内，所以i+mid<=m+1,即i<=m+1-mid;j+mid<=n+1,即j<=n+1-mid
            for (int i = 1; i <= m - mid + 1; i++) {
                for (int j = 1; j <= n - mid + 1; j++) {
                    //通过子矩阵和计算正方形面积，左上角(x1,y1),右下角(x2,y2)
                    //公式area(x1,y1,x2,y2)=pSum(x2,y2)-pSum(x1-1,y2)-pSum(x2,y1-1)+pSum(x1-1,y1-1)
                    //x1=i,y1=j,x2=i+mid-1,y2=j+mid-1，保证边长为mid
                    int area = pSum[i + mid - 1][j + mid - 1] - pSum[i - 1][j + mid - 1]
                            - pSum[i + mid - 1][j - 1] + pSum[i - 1][j - 1];
                    if (area <= threshold) {
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                ans = mid;
                //解可能还在右侧
                left = mid;
            } else {
                //解可能在左侧
                right = mid - 1;
            }
        }

        return ans;
    }
}
