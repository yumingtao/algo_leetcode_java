package com.ymt.leetcode.pre_sum.random_pick_with_weight;

/**
 * 前缀和+二分
 * <p>
 * 分析过程:
 * 索引 0 1 2
 * 4 3 2
 * 前缀和 4 7 9
 * 平铺乘数组      0 0 0 0 1 1 1 2 2
 * 边界范围分别是  [1,4],  [5,7],[8,9]
 * 边界范围的索引    0       1     2
 * 给定一个随机数x>=1且x<=9,看x落在哪个范围
 * left = preSum[i] - w[i] + 1
 * right = preSum[i]
 * 如果 left <= x <= right，则返回i
 * x <= preSum[i]
 * 使用二分查找到大于x的最小的preSum[i], i是解
 *
 * @author yumingtao
 * @date 2021/9/22 09:31
 */

public class Solution {
    private int[] preSum;
    private int totalSum;
    public Solution(int[] w) {
        int n = w.length;
        //初始化前缀和数组,正常前缀和数组长度是n+1，真正的数据从索引1开始，preSum[0]=0
        preSum = new int[n];
        //此处经过上边的分析和题目中指出w索引从0开始，所以此处让preSum的真正数据也从0开始
        preSum[0] = w[0];

        for(int i = 1; i < n; i++){
            preSum[i] = preSum[i - 1] + w[i];
        }

        totalSum = preSum[n - 1];
    }

    public int pickIndex() {
        //0.0 <= Math.random() < 1.0
        //因为x的取值范围是[1, totalSum]
        int x = (int)(Math.random() * totalSum) + 1;

        //使用二分查找
        int left = 0;
        int right = preSum.length - 1;

        //终止于left==right
        while (left < right){
            int mid = (right - left) / 2 + left;

            if(preSum[mid] >= x){
                //解可能还在左边
                right = mid;
            }else{
                //解一定在右边, 此处mid要+1
                left = mid + 1;
            }
        }

        return left;
    }
}

