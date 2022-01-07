package com.ymt.leetcode.two_pointers.minimum_swaps_to_group_all_1s_together;

/**
 * @Description Solution1优化
 * @author yumingtao
 * @date 2022-01-06 22:34
 */
public class Solution2 {
    public int minSwaps(int[] data) {
        //统计1的sum
        int oneSum = 0;
        int len = data.length;
        for (int i = 0; i < len; ++i) {
            oneSum += data[i];
        }
        //特殊情况判断
        if (oneSum < 2 || oneSum == len) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int zeroCount = 0;
        //统计长度为oneSum滑窗内0的个数
        while(right < oneSum){
            zeroCount += data[right] ^ 1;
            ++right;
        }
        int ans = zeroCount;
        while (right < len) {
            //right滑入
            zeroCount += data[right] ^ 1;
            //left滑出
            zeroCount -= data[left] ^ 1;
            ans = Math.min(ans, zeroCount);
            //继续向右滑动窗口
            ++left;
            ++right;
        }
        return ans;
    }
}
