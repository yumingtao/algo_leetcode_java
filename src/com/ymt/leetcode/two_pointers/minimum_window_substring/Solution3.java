package com.ymt.leetcode.two_pointers.minimum_window_substring;

/**
 * @author yumingtao
 * @date 2021/11/24 14:44
 */
public class Solution3 {
    public String minWindow(String s, String t) {
        int len = 'z' - 'A' + 1;
        int[] tCount = new int[len];
        int[] windowCount = new int[len];
        int tLetterCount = 0;

        char[] chs = t.toCharArray();
        //统计t中出现的字母的个数
        for (char ch : chs) {
            tCount[ch - 'A']++;
        }

        //统计t中出现的字母
        for (int i = 0; i < len; i++) {
            //tCount[i]>0表示在t中出现过
            if (tCount[i] > 0) {
                tLetterCount++;
            }
        }

        int left = 0;
        int right = 0;
        int matchCount = 0;
        int sLen = s.length();
        int minLen = sLen + 1;
        int start = 0;

        while (right < sLen) {
            //判断滑入窗口的新字母
            //新字母的索引
            int newRightIndex = s.charAt(right) - 'A';
            if (tCount[newRightIndex] > 0) {
                //如果新字母在t中出现,滑窗中该字母出现的次数加1
                windowCount[newRightIndex]++;
                if (windowCount[newRightIndex] == tCount[newRightIndex]) {
                    //如果滑窗中和t中字母newRightIndex的个数一旦相等,匹配个数加1
                    //之后再出现相同的字母，滑窗中该字母的统计个数增加，但matchCount不变
                    matchCount++;
                }
            }

            //如果滑窗中包含t中所有字母，且每个字母个数相等，则满足条件，记录长度和起始位置
            while (matchCount == tLetterCount) {
                int curLen = right - left + 1;
                if (minLen > curLen) {
                    minLen = curLen;
                    start = left;
                }

                //此时right不动，开始收缩left
                int leftIndex = s.charAt(left) - 'A';
                if (tCount[leftIndex] > 0) {
                    //如果将要滑出的字母在t中，则滑窗中该字母的统计个数减1
                    windowCount[leftIndex]--;
                    if (windowCount[leftIndex] < tCount[leftIndex]) {
                        //一旦出现滑窗中字母的统计个数小于t中该字母的统计个数，说明不匹配，匹配的个数减1
                        matchCount--;
                        //此时可以直接跳出循环,while本身判断条件就可以跳出循环
                        //break;
                    }
                }
                ++left;
            }
            //当left向右移动到matchCount!=tLetterCount的位置，开始继续移动right
            ++right;
        }

        return minLen == s.length() + 1 ? "" : s.substring(start, start + minLen);
    }
}
