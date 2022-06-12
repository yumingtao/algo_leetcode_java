package com.ymt.leetcode.two_pointers.minimum_swaps_to_group_all_1s_together;

/**
 * 思路：Solution1优化，将初始滑窗提到外边
 *
 * @author yumingtao
 * @date 2022/1/7 10:11
 */
public class Solution3 {
    public int minSwaps(int[] data) {
        //统计1的sum
        int oneSum = 0;
        int len = data.length;
        for (int i = 0; i < len; ++i) {
            if (data[i] == 1) {
                ++oneSum;
            }
        }
        //特殊情况判断
        if (oneSum < 2 || oneSum == len) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int zeroCount = 0;
        //统计长度为oneSum滑窗内0的个数
        while (right < oneSum) {
            if (data[right] == 0) {
                ++zeroCount;
            }
            ++right;
        }
        int ans = zeroCount;
        while (right < len) {
            //right滑入
            if (data[right] == 0) {
                ++zeroCount;
            }
            //left滑出
            if (data[left] == 0) {
                --zeroCount;
            }
            ans = Math.min(ans, zeroCount);
            //继续向右滑动窗口
            ++left;
            ++right;
        }
        return ans;
    }
}
