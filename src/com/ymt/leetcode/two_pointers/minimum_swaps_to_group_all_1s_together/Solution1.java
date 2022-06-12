package com.ymt.leetcode.two_pointers.minimum_swaps_to_group_all_1s_together;

/**
 * @Description 滑窗
 * 1. 先统计1的总数sum，滑窗的长度为sum
 * 2. 统计滑窗内0的个数，0的个数即为交换为1的次数
 * 3. 在滑窗向右移动过程中，找出滑窗中最少的0的个数即为解
 * 注意：注意1的个数小于等于1，或全是1的极端情况
 *
 * @author yumingtao
 * @date 2022-01-06 21:28
 */
public class Solution1 {
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
        int ans = len;
        while (right < len) {
            //统计长度为oneSum滑窗内0的个数
            while (right - left + 1 <= oneSum) {
                if (data[right] == 0) {
                    ++zeroCount;
                }
                ++right;
            }
            ans = Math.min(ans, zeroCount);
            //继续向右滑动窗口，left滑出
            if (data[left] == 0) {
                --zeroCount;
            }
            ++left;
        }
        return ans;
    }
}
