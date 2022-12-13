package com.ymt.leetcode.string.find_common_characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description 参考题解
 * @author yumingtao
 * @date 2022-12-13 22:45
 */
public class Solution2 {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        /*for(int i = 0; i < 26; ++i){
            count[i] = 101;
        }*/
        Arrays.fill(count, Integer.MAX_VALUE);
        for (int i = 0; i < words.length; ++i) {
            int[] currCount = new int[26];
            for (char c : words[i].toCharArray()) {
                currCount[c - 'a']++;
            }
            for (int k = 0; k < 26; ++k) {
                count[k] = Math.min(count[k], currCount[k]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            while (count[i] > 0) {
                ans.add(String.valueOf((char) (i + 'a')));
                count[i]--;
            }
        }
        return ans;
    }
}
