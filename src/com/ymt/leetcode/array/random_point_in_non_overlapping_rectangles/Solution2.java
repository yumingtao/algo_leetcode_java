package com.ymt.leetcode.array.random_point_in_non_overlapping_rectangles;

/**
 * @author yumingtao
 * @date 2021/9/23 20:16
 */
public class Solution2 {
    private int[] pSum;
    private int[][] rects;

    public Solution2(int[][] rects) {
        this.rects = rects;

        //一共有n个矩形
        int n = rects.length;

        //随机均匀的选取矩形覆盖的点
        //1.计算每个矩形中点的数量
        //2.求出矩形中点数量组成的前缀和
        int pCount;
        pSum = new int[n];
        for (int i = 0; i < n; i++) {
            int width = rects[i][2] - rects[i][0] + 1;
            int height = rects[i][3] - rects[i][1] + 1;
            pCount = width * height;
            pSum[i] = i == 0 ? pCount : pSum[i - 1] + pCount;
        }
    }

    public int[] pick() {
        //1.生成随机数x, x范围是[1,所有点的数量]
        //0.0 <= Math.random() < 1.0
        //矩形中的点至少有一个，最多有pSum[pSum.length - 1]个
        //所以也要+1
        int x = (int) (Math.random() * pSum[pSum.length - 1]) + 1;

        //2.二分查找x落在哪个矩形中
        int index = binarySearch(x);
        // 有可能存在找不到index，即index=-1，此时说明x落在index+1的矩形中
        index = index == -1 ? 0 : index;

        //index这个矩形可能就是x所在的矩形，也可能不是x所在的矩形
        //当index所在的矩形就是x所在的矩形时，相对位置y=x-pSum[index-1], 则判断条件是x<=pSum[index]
        //当index所在矩形不是x所在的矩形,即index是x所在矩形的前一个矩形，相对位置y=x-pSum[index]，则判断条件是x>pSum[index]
        int y;
        if (x <= pSum[index]) {
            //当index所在的矩形就是x所在的矩形
            y = index == 0 ? x : x - pSum[index - 1];
        } else {
            //当index所在的矩形就是x的前一个矩形
            y = x - pSum[index];
            //+1才是index所在的矩形
            index++;
        }

        //3.在矩形中随机获取一个点，此处仍然使用x做为随机的点
        //找到的index为x所在矩形的下标值，计算x对应的坐标
        int width = rects[index][2] - rects[index][0] + 1;
        int ansX = rects[index][0] + (y - 1) % width;
        int ansY = rects[index][1] + (y - 1) / width;

        return new int[]{ansX, ansY};
    }

    /**
     * 二分查找
     * 找到小于等于目标值的，最大的pSum的索引i，则x可能在矩形i中，也可能在矩形i+1中，这个不重要
     * 找到i之后，使用x-pSum[i]可以得到x在矩形i中的相对位置
     *
     * @param target 目标值
     * @return 返回大于目标值最小的前缀和的索引
     */
    private int binarySearch(int target) {
        //假设当前i，当前矩形点的数量是p[i]，当前的前缀和是pSum[i] = pSum[i-1]+p[i]
        //随机数x要落在当前i所在的矩形，应该满足 pSum[i-1] <= x < pSum[i]
        int left = -1;
        int right = pSum.length - 1;

        //终止于left == right
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;

            //找<=x的最大的pSum
            if (pSum[mid] <= target) {
                //所找的解可能还在右侧
                //此处是left=mid时
                left = mid;
            } else {
                //所找的解肯定在左侧
                right = mid - 1;
            }
        }

        return left;
    }
}