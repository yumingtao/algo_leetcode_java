package com.ymt.leetcode.array.random_point_in_non_overlapping_rectangles;

/**
 * @author yumingtao
 * @date 2021/9/23 20:16
 */
public class Solution {
    private int[] pSum;
    private int[][] rects;

    public Solution(int[][] rects) {
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

        //3.在矩形中随机获取一个点，此处仍然使用x做为随机的点
        //找到的index为x所在矩形的下标值，计算x对应的坐标
        int width = rects[index][2] - rects[index][0] + 1;

        //取矩形left中的点y=x-pSum[index - 1], 即x在索引为index的矩形中的相对位置，注意位置范围 [1, pCount]
        //将线性的[1, pCount]按照列(width=x1-x0)转换乘二维,注意y要-1，才能保证二维数组下标从0开始
        //注意pSum[left - 1] = pSum[left] - pCount，直接使用pSum[left - 1]可能下标越界
        //所以可以使用当前前缀和减去当前矩形中点的个数来表示index-1的前缀和，pSum[index] - width * height
        //int height = rects[index][3] - rects[index][1] + 1;
        //int y = x - (pSum[index] - width * height);
        //或是直接判断index是否为0
        int y = index == 0 ? x : x - pSum[index - 1];
        int ansX = rects[index][0] + (y - 1) % width;
        int ansY = rects[index][1] + (y - 1) / width;

        return new int[]{ansX, ansY};
    }

    /**
     * 二分查找
     *
     * @param target 目标值
     * @return 返回大于目标值最小的前缀和的索引
     */
    private int binarySearch(int target) {
        //假设当前i，当前矩形点的数量是p[i]，当前的前缀和是pSum[i] = pSum[i-1]+p[i]
        //随机数x要落在当前i所在的矩形，应该满足 pSum[i-1] < x <= pSum[i]
        int left = 0;
        int right = pSum.length - 1;

        //终止于left == right
        while (left < right) {
            int mid = (right - left) / 2 + left;

            //找>=x的最小的pSum
            if (pSum[mid] >= target) {
                //所找的解可能还在左侧
                right = mid;
            } else {
                //所找的解肯定在右侧
                left = mid + 1;
            }
        }

        return left;
    }
}