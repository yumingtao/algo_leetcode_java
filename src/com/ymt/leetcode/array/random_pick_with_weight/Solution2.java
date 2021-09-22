package com.ymt.leetcode.array.random_pick_with_weight;

/**
 * 前缀和+朴素
 * <p>
 * 分析过程:
 * 索引   0 1 2
 *       4 3 2
 * 前缀和 4 7 9
 * 一个随机数x
 * 当x<=4时，返回0
 * 当x<=7时，返回1
 * 求解找到比x大的最小的数的i
 *
 * @author yumingtao
 * @date 2021/9/22 10:41
 */

public class Solution2 {
    private int[] preSum;
    private int totalSum;
    public Solution2(int[] w) {
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

        for(int i = 0; i < preSum.length; i++){
            if(x <= preSum[i]){
                return i;
            }
        }
        return -1;
    }
}

