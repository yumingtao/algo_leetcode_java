package com.ymt.leetcode.two_pointers.find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：滑窗
 *
 * @author yumingtao
 * @date 2021/12/27 16:01
 */
public class Solution1 {
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int[] pCounter = new int[26];

        //预处理p
        for (char ch : p.toCharArray()) {
            ++pCounter[ch - 'a'];
        }

        int[] slideCounter = new int[26];
        List<Integer> ans = new ArrayList<>();
        //遍历s，固定长度的滑动窗口，窗口长度pLen
        int right = 0;
        char[] sArr = s.toCharArray();
        for (int left = 0; left < s.length() - pLen; ++left) {
            //处理起始滑窗
            if (left == 0) {
                while (right < pLen) {
                    ++slideCounter[sArr[right] - 'a'];
                    ++right;
                }
                --right;
            }

            if (isEquals(pCounter, slideCounter)) {
                ans.add(left);
            }
            //left往后走，移除left元素的统计
            --slideCounter[sArr[left] - 'a'];
            //right往后走，保证固定的滑窗大小
            if(right < s.length()){
                ++slideCounter[sArr[++right] - 'a'];
            }else{
                break;
            }
        }
        return ans;
    }

    private boolean isEquals(int[] source, int[] target) {
        for (int i = 0; i < target.length; ++i) {
            if (source[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
