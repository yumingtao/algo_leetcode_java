package com.ymt.leetcode.two_pointers.longest_repeating_character_replacement;

/**
 * 思路：滑窗
 * 1.滑动窗口中相同字母的最大长度+k刚大于滑动窗口的长度时
 * 1.1 无法通过k次替换得到全部相同的字母
 * 1.2 left向右移动1位之后，继续向右移动right
 * <p>
 * 备注：
 * 1.为什么left只向后移动1位就可以了
 * 1.1 如果移走的是最大长度的字母，新的[left,right]范围中，还是无法通过k次替换得到全部相同的字母
 * 1.2 如果移走的是非最大长度的字母，新的[left,right]范围中，可以通过k次替换得到全部相同的字母，但长度短于此前的解，所以无需计算
 *
 * @author yumingtao
 * @date 2021/11/26 11:30
 */
public class Solution2 {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int[] windowLetterCounts = new int[26];
        int windowLetterMaxCount = 0;
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < len) {
            int rightLetterIndex = s.charAt(right) - 'A';
            windowLetterCounts[rightLetterIndex]++;
            windowLetterMaxCount = Math.max(windowLetterMaxCount, windowLetterCounts[rightLetterIndex]);
            int windowLen = right - left + 1;
            //滑动窗口中相同字母的最大长度+k刚大于滑动窗口的长度时,无法通过k次替换得到全部相同的字母
            if (windowLen - windowLetterMaxCount > k) {
                //windowLen要减1
                --windowLen;
                //滑出窗口的字母统计计数减1
                windowLetterCounts[s.charAt(left) - 'A']--;
                //left向后移动1位
                ++left;
            }

            //更新解
            maxLen = Math.max(maxLen, windowLen);
            //right继续向后移动
            ++right;
        }

        return maxLen;
    }
}
