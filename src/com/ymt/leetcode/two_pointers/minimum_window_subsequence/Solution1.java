package com.ymt.leetcode.two_pointers.minimum_window_subsequence;

/**
 * @Description TODO
 * @author yumingtao
 * @date 2022-01-03 21:02
 */
public class Solution1 {
    public String minWindow(String s1, String s2) {
        char[] sArr = s1.toCharArray();
        char[] tArr = s2.toCharArray();
        int tIndex = 0;
        int startIndex = 0;
        int minLen = 20001;
        int left = 0;
        for(int right = 0; right < sArr.length; ++right){
            if(sArr[right] != tArr[tIndex]){
                continue;
            }
            if(tIndex > 0 && sArr[right] == tArr[tIndex - 1]){
                //left = s1.indexOf(tArr[tIndex - 1], left + 1);
                continue;
            }
            if(tIndex == 0){
                left = s1.indexOf(tArr[tIndex]);
            }
            ++tIndex;
            if(tIndex == tArr.length){
                int len = right - left + 1;
                System.out.println("left:" + left + ", right:" + right + ",minLen:" + minLen);
                if(minLen > len){
                    startIndex = left;
                    minLen = len;
                }
                tIndex = 0;
            }
        }
        return minLen == 20001 ? "" : s1.substring(startIndex, startIndex + minLen);
    }
}
