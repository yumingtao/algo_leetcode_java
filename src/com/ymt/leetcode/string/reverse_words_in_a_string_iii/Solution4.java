package com.ymt.leetcode.string.reverse_words_in_a_string_iii;

/**
 * @description 参考题解
 * @author yumingtao
 * @date 2022-10-16 16:05
 */
public class Solution4 {
    public String reverseWords(String s) {
        int end = 0;
        StringBuilder ans = new StringBuilder();
        while (end < s.length()) {
            int start = end;
            //先找到一个单词
            while (end < s.length() && s.charAt(end) != ' ') {
                ++end;
            }
            //翻转找到的单词中翻转后的字符,[start, end-1]
            for (int i = end - 1; i >= start; i--) {
                ans.append(s.charAt(i));
            }

            //题目中指明只包含一个空格，如果是多个空格，可以使用while
            if (end < s.length() && s.charAt(end) == ' ') {
                ans.append(" ");
            }
            ++end;
        }

        return ans.toString();
    }
}
