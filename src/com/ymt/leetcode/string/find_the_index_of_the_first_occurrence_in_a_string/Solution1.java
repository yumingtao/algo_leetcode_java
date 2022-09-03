package com.ymt.leetcode.string.find_the_index_of_the_first_occurrence_in_a_string;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-03 16:19
 */
public class Solution1 {
    public int strStr(String haystack, String needle) {
        int needleLen = needle.length();
        int haystackLen = haystack.length();
        if (haystackLen < needleLen) {
            return -1;
        }
        for (int i = 0; i < haystackLen - needleLen + 1; ++i) {
            boolean found = true;
            for (int j = 0; j < needleLen; ++j) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found == true) {
                return i;
            }
        }
        return -1;
    }
}
