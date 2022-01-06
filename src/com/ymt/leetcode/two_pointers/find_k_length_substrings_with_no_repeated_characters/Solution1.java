package com.ymt.leetcode.two_pointers.find_k_length_substrings_with_no_repeated_characters;

/**
 * @Description 滑窗
 * @author yumingtao
 * @date 2022-01-06 19:48
 */
public class Solution1 {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int[] letters = new int[26];
        int left = 0;
        int right = 0;
        char[] sArr = s.toCharArray();
        int ans = 0;
        while (right < s.length()) {
            if (letters[sArr[right] - 'a'] == 0) {
                ++letters[sArr[right] - 'a'];
            } else {
                --letters[sArr[left] - 'a'];
                ++left;
                continue;
            }

            if (right - left + 1 == k) {
                ++ans;
                --letters[sArr[left] - 'a'];
                ++left;
            }
            ++right;
        }
        return ans;
    }
}
