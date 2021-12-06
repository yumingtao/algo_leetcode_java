package com.ymt.leetcode.two_pointers.permutation_in_string;

import java.util.Arrays;

/**
 * 思路：滑窗
 *
 * @author yumingtao
 * @date 2021/12/3 16:00
 */
public class Solution3 {
    public boolean checkInclusion(String s1, String s2) {
        //s1的长度，看作是滑动窗口的长度
        int slideLen = s1.length();
        int s2Len = s2.length();
        if(slideLen > s2Len){
            return false;
        }
        //先预处理s1包含的字符数统计，这里使用int数组
        int[] s1ChCounts = new int[26];
        for (char ch : s1.toCharArray()) {
            s1ChCounts[ch - 'a']++;
        }
        //在s2中选取slideLen长度的窗口，判断是否包含s1的排列
        int start = 0;
        int end = 0;
        int[] s2ChCounts = new int[26];
        //end-start+1=slideLen -> end=start+slideLen-1
        //end<s2.length() -> start+slideLen-1<s2.length() -> start<s2.length()-slideLen+1
        while (start <= s2Len - slideLen) {
            //统计滑入的字符
            if (end == 0) {
                while (end < slideLen) {
                    s2ChCounts[s2.charAt(end) - 'a']++;
                    ++end;
                }
                --end;
            } else {
                s2ChCounts[s2.charAt(end) - 'a']++;
            }

            if (Arrays.equals(s1ChCounts, s2ChCounts)) {
                return true;
            }

            //start和end同时向右移动一位
            //先清理滑出窗口的字母统计
            s2ChCounts[s2.charAt(start) - 'a']--;
            ++start;
            ++end;
        }

        return false;
    }
}
