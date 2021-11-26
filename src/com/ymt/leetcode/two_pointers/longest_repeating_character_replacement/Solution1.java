package com.ymt.leetcode.two_pointers.longest_repeating_character_replacement;

/**
 * 思路：滑窗
 * 1.滑动窗口中相同字母的最大长度+k刚大于滑动窗口的长度时
 * 1.1 无法通过k次替换得到全部相同的字母，此时更新解
 * 1.2 left向右移动1位之后，继续向右移动right
 * <p>
 * 备注：
 * 1.为什么left只向后移动1位就可以了
 * 1.1 如果移走的是最大长度的字母，新的[left,right]范围中，还是无法通过k次替换得到全部相同的字母
 * 1.2 如果移走的是非最大长度的字母，新的[left,right]范围中，可以通过k次替换得到全部相同的字母，但长度短于此前的解，所以无需计算
 *
 * @author yumingtao
 * @date 2021/11/25 09:24
 */
public class Solution1 {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int left = 0;
        int right = 0;
        int[] letterCounts = new int[26];
        int maxLen = 0;
        int windowLetterMaxLen = 0;
        while (right < len) {
            int rightLetterIndex = s.charAt(right) - 'A';
            //同时更新窗口中字母出现的计数
            letterCounts[rightLetterIndex]++;
            //计算窗口中长度最长的字符长度
            windowLetterMaxLen = Math.max(windowLetterMaxLen, letterCounts[rightLetterIndex]);
            int windowLen = right - left + 1;
            int restLen = windowLen - windowLetterMaxLen;
            if (restLen <= k) {
                //当restLen==k==0的时候，此时是全是一个字母，用当前窗口的长度更新maxLen
                if (k == 0) {
                    maxLen = Math.max(maxLen, windowLen);
                } else if (windowLen == len) {
                    //否则，遍历完字符串，但是长度最长字母意外的数量<k,直接返回s的长度
                    return len;
                }
            } else {
                //当不同与最长长度的字母的数量大于k时，替换k个字母后，窗口內字母不全是一样，不满足条件
                //此时计算当前的最大长度，然后left加1
                maxLen = Math.max(maxLen, windowLen - 1);
                //更新letterCounts
                letterCounts[s.charAt(left) - 'A']--;
                ++left;
            }
            //当不满足条件后，left向右移动1位，然后再重新开始移动right
            ++right;
        }

        return maxLen;
    }
}
