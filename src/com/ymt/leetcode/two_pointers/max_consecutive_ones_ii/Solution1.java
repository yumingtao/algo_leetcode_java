package com.ymt.leetcode.two_pointers.max_consecutive_ones_ii;

/**
 * 思路:滑窗
 *  * 1.right向右
 *  * 1.1 遇到0且zeroCount=0，zeroCount++,更新解
 *  * 1.2 遇到0且zeroCount!=0,说明在[left,right]上，0的个数超了，更新解，然后收缩left到第一个0的下一个位置
 *  * 1.3 遇到的不是0，不管zeroCount是否为0，更新解，right继续向右
 *
 * @author yumingtao
 * @date 2021/12/6 16:47
 */
public class Solution1 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zeroCount = 0;
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                if (zeroCount == 0) {
                    ++zeroCount;
                    maxLen = Math.max(maxLen, right - left + 1);
                } else {
                    //0的数量超过1，更新解, right已经指向0了->right-1-left+1
                    maxLen = Math.max(maxLen, right - left);
                    //将left更新到上一个0的后一个位置
                    if (nums[left] != 0) {
                        while (nums[left] != 0) {
                            ++left;
                        }
                    }
                    ++left;
                    //zeroCount = 1;
                }
            } else {
                //right没有指向0->right-left+1
                maxLen = Math.max(maxLen, right - left + 1);
            }
            ++right;
        }
        return maxLen;
    }
}
