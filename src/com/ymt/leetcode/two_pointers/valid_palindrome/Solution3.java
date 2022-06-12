package com.ymt.leetcode.two_pointers.valid_palindrome;

/**
 * 思路：使用StringBuffer
 *
 * @author yumingtao
 * @date 2022/1/26 16:58
 */
public class Solution3 {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toUpperCase(s.charAt(i)));
            }
        }
        StringBuffer rsb = new StringBuffer(sb).reverse();
        return sb.toString().equalsIgnoreCase(rsb.toString());
    }
}
