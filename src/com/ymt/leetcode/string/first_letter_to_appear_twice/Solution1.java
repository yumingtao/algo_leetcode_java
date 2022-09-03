package com.ymt.leetcode.string.first_letter_to_appear_twice;

/**
 * @description
 * @author yumingtao
 * @date 2022-09-03 16:32
 */
public class Solution1 {
    public char repeatedCharacter(String s) {
        int[] counts = new int[26];
        char[] chs = s.toCharArray();
        char ans = ' ';
        for(char ch : chs){
            counts[ch - 'a']++;
            if(counts[ch - 'a'] == 2){
                ans = ch;
                break;
            }
        }
        return ans;
    }
}
