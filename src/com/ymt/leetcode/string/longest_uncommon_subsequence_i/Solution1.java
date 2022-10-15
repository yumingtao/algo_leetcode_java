package com.ymt.leetcode.string.longest_uncommon_subsequence_i;

/**
 * @description 参考题解
 * @author yumingtao
 * @date 2022-10-15 15:46
 */
public class Solution1 {
    public int findLUSlength(String a, String b) {
        //a的最长子序列是a，b的最长子序列是b
        //如果a和b不相同时，取长度最长的作为特殊序列，它一定不是另一个最长子序列的子序列
        //如果ahb相同时，他们没有最长特殊序列
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
