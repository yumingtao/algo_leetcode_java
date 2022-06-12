package com.ymt.leetcode.two_pointers.unique_substrings_in_wraparound_string;

/**
 * 思路：滑窗找以每个字符结尾的最长连续子串
 * 1. 滑动窗口找出最长的连续子串，可以使用(A[i]-A[i-1]-1)%26==0判读字母是否连续
 * 2. 得到结尾的字母，并记录对应最长连续子串的长度
 * 3. 累加每个字母结尾的最大长度得到解
 * @author yumingtao
 * @date 2022/1/11 09:31
 */
public class Solution1 {
    public int findSubstringInWraproundString(String p) {
        //数组存储每个字母结尾的最长字符窗的长度
        int[] letterMaxLen = new int[26];
        char[] pArr = p.toCharArray();
        int len = 0;
        for (int right = 0; right < p.length(); ++right) {
            if (right > 0 && (pArr[right] - pArr[right - 1] - 1) % 26 != 0) {
                len = 1;
            } else {
                ++len;
            }
            int lastLetter = pArr[right] - 'a';
            letterMaxLen[lastLetter] = Math.max(letterMaxLen[lastLetter], len);
        }

        int ans = 0;
        for (int num : letterMaxLen) {
            ans += num;
        }
        return ans;
    }
}
