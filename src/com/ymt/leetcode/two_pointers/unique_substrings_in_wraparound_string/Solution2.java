package com.ymt.leetcode.two_pointers.unique_substrings_in_wraparound_string;

/**
 * @Description 思路：同Solution1
 *
 * @author yumingtao
 * @date 2022-01-11 20:49
 */
public class Solution2 {
    public int findSubstringInWraproundString(String p) {
        //数组存储每个字母结尾的最长字符窗的长度
        int[] letterMaxLen = new int[26];
        char[] pArr = p.toCharArray();
        int len = 0;
        for (int right = 0; right < p.length(); ++right) {
            if (right > 0 && (pArr[right] == pArr[right - 1] + 1 || (pArr[right] == 'a' && pArr[right - 1] == 'z'))) {
                ++len;
            } else {
                len = 1;
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
