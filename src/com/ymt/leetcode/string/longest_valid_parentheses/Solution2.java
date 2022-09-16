package com.ymt.leetcode.string.longest_valid_parentheses;

/**
 * @description 参考题解
 * @author yumingtao
 * @date 2022-09-16 14:28
 */
public class Solution2 {
    public int longestValidParentheses(String s) {
        int ans = 0;
        int leftCount = 0;
        int rightCount = 0;
        //正向遍历
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                ++leftCount;
            } else {
                ++rightCount;
            }
            if (leftCount == rightCount) {
                ans = Math.max(ans, rightCount + leftCount);
            } else if (rightCount > leftCount) {
                leftCount = 0;
                rightCount = 0;
            }
        }

        leftCount = 0;
        rightCount = 0;
        //反向遍历
        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            if (c == '(') {
                ++leftCount;
            } else {
                ++rightCount;
            }
            if (leftCount == rightCount) {
                ans = Math.max(ans, rightCount + leftCount);
            } else if (rightCount < leftCount) {
                leftCount = 0;
                rightCount = 0;
            }
        }

        return ans;
    }
}
