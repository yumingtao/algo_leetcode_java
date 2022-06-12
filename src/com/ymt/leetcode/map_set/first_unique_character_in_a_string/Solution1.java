package com.ymt.leetcode.map_set.first_unique_character_in_a_string;

import java.util.HashMap;

/**
 * 思路:使用HashMap
 *
 * @author yumingtao
 * @date 2022/3/1 09:51
 */
public class Solution1 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        for (char ch : sArr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < sArr.length; ++i) {
            if (map.get(sArr[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
