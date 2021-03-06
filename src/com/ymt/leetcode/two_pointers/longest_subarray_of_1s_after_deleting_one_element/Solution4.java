package com.ymt.leetcode.two_pointers.longest_subarray_of_1s_after_deleting_one_element;

/**
 * 思路: 官方题解-递推
 * 1.假设删除第i个位置,i的前边全1子数组的长度与i的后边全1子数组的长度之和，求最大值就是解
 *
 * @author yumingtao
 * @date 2021/12/15 16:39
 */
public class Solution4 {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        //以第i位结尾的最长连续子数组长度，一共len个数，所以长度最多是len
        int[] p = new int[len];
        //正向循环预处理p
        p[0] = nums[0];
        for (int i = 1; i < len; ++i) {
            /*可以这样理解：
            * 1.如果第i个数是0，那么以0结尾的全为1的子数组长度为0
            * 2.如果第i个数是1，那么以1结尾的全为1的子数组的长度为1+p[i-1]，不管p[i-1]是0还是有值
            */
            p[i] = nums[i] == 0 ? 0 : p[i - 1] + 1;
        }

        //以第i位开头的最长连续子数组长度，一共len个数，所以长度最多是len
        int[] s = new int[len];
        //反向遍历预处理s
        s[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; --i) {
            s[i] = nums[i] == 0 ? 0 : s[i + 1] + 1;
        }

        int maxLen = 0;
        //枚举删除的位置
        for (int i = 0; i < len; ++i) {
            //假设第i个位置，i之前最长全是1的数组长度是p[i-1],i之后最长全是1的数组长度是s[i+1]
            //注意下标i的范围不要越界
            int pLen = i == 0 ? 0 : p[i - 1];
            int sLen = i == len - 1 ? 0 : s[i + 1];
            maxLen = Math.max(maxLen, pLen + sLen);
        }
        return maxLen;
    }
}
