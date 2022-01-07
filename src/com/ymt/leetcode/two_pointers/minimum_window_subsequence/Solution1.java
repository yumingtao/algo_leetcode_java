package com.ymt.leetcode.two_pointers.minimum_window_subsequence;

/**
 * @Description TODO
 * @author yumingtao
 * @date 2022-01-03 21:02
 */
public class Solution1 {
    public String minWindow(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        int s2Index = 0;
        int s1MinLenLeft = 0;
        int minLen = 20001;
        //遍历s1
        for(int right = 0; right < s1Arr.length; ++right){
            if(s1Arr[right] != s2Arr[s2Index]){
                continue;
            }
            //匹配上了s2中的字符，向后移动s2的索引，寻找匹配下一个字符
            ++s2Index;
            //如果已经匹配到了s2中最后一个字符，说明找到了右边right
            if(s2Index == s2Arr.length){
                //System.out.println("s2Index:" + s2Index + ",right:" + right);
                int i = right;
                //跳过s2最后一个字符
                int j = s2Index - 1;
                //开始寻找左边界，从right开始逆遍历s1，找到s2Arr[0]
                while (j >= 0){
                    if(s1Arr[i] == s2Arr[j]){
                        --j;
                    }
                    --i;
                }
                //多减了1，需要补回来
                ++i;
                int len = right - i + 1;
                if(minLen > len){
                    s1MinLenLeft = i;
                    minLen = len;
                }
                System.out.println("s1MinLenLeft:" + s1MinLenLeft + ", right:" + right + ",minLen:" + minLen);
                //将s2的索引位置还原到0，重新开始一轮匹配
                s2Index = 0;
                //将s1的索引位置设置为i，使可以从s1的i+1位置开始匹配
                right = i;
            }
        }
        return minLen == 20001 ? "" : s1.substring(s1MinLenLeft, s1MinLenLeft + minLen);
    }
}
