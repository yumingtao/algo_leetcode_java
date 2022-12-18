package com.ymt.leetcode.string.remove_all_adjacent_duplicates_in_string;

/**
 * @description 参考题解评论
 * @author yumingtao
 * @date 2022-12-18 17:23
 */
public class Solution2 {
    public String removeDuplicates(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        int fast = 1;
        while (fast < n) {
            int slow = fast - 1;
            while (fast < n && chs[slow] == chs[fast]) {
                chs[fast++] = ' ';
                chs[slow] = ' ';
                while (slow > 0 && chs[slow] == ' ') {
                    --slow;
                }
            }
            ++fast;
        }
        return new String(chs).replace(" ", "");
    }
}
