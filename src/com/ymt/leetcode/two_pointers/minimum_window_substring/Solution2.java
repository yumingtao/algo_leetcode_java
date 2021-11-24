package com.ymt.leetcode.two_pointers.minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路:不定长度的滑动窗口
 *
 * @author yumingtao
 * @date 2021/11/24 09:44
 */
public class Solution2 {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int minLen = s.length();
        String minStr = "";

        //预处理，统计t中出现的字母及字母个数
        Map<Character, Integer> tCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);
        }
        //用于统计滑动窗口中出现的字母及字母个数
        Map<Character, Integer> sCount = new HashMap<>();

        while (right <= s.length()) {
            //出现在滑窗中的字符串
            String subStr = s.substring(left, right);
            if (sCount.size() == 0) {
                //首次，统计滑动窗口中出现的字母及字母个数
                for (char ch : subStr.toCharArray()) {
                    sCount.put(ch, sCount.getOrDefault(ch, 0) + 1);
                }
            } else {
                //将右侧滑进窗口的字母加入到sCount统计中
                char rightCh = subStr.charAt(subStr.length() - 1);
                sCount.put(rightCh, sCount.getOrDefault(rightCh, 0) + 1);
            }

            //判断滑动窗口中的字符串是否包含t
            while (isContains(subStr, sCount, t, tCount)) {
                //如果包含t，更新最小长度和最小子串
                if (minLen >= subStr.length()) {
                    minLen = subStr.length();
                    minStr = subStr;
                }

                //如果包含t，right继续增加只会使子串更长，所以此时开始收缩left
                //移动left前，先将滑出窗口字母的个数减1
                char leftCh = s.charAt(left);
                sCount.put(leftCh, sCount.get(leftCh) - 1);
                //移动left
                ++left;
                if (left < right) {
                    //如果还存在子串，得到新的滑窗中的子串，在while循环中继续判断子串是否包含t
                    subStr = s.substring(left, right);
                } else {
                    //如果不存在子串，跳出循环，继续外层循环
                    break;
                }
            }
            //继续向右移动right
            ++right;
        }

        return minStr;
    }

    private boolean isContains(String s, Map<Character, Integer> sCount, String t, Map<Character, Integer> tCount) {
        for (char ch : tCount.keySet()) {
            if (!sCount.containsKey(ch) || sCount.get(ch).intValue() < tCount.get(ch).intValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int A = 'A';
        int Z = 'Z';
        int a = 'a';
        int z = 'z';
        System.out.println(A);
        System.out.println(Z);
        System.out.println(a);
        System.out.println(z);
    }
}
