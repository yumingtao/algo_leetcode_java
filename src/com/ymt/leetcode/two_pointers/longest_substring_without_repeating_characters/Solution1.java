package com.ymt.leetcode.two_pointers.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：双指针 + Map
 * 1.定义left，right, map存储上一次字符出现的索引位置
 * 2.right向右每走一步，判断map中是否存在
 * 2.1 如果不存在，存入map并更新maxLen
 * 2.2 如果存在，left向左移动到right上一次出现的+1位置，在移动的过程中，删除map中left经过的数据
 *
 * @author yumingtao
 * @date 2021/11/26 13:19
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        int left = 0;
        int right = 0;
        //map存储上一次字符出现的索引位置
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = -1;
        while (right < len) {
            char rightChKey = s.charAt(right);
            //如果right已经存在
            if (map.containsKey(rightChKey)) {
                int lastRightChIndex = map.get(rightChKey);
                //left向左移动到right上一次出现的+1位置，在移动的过程中，删除map中left经过的数据
                while (left <= lastRightChIndex) {
                    map.remove(s.charAt(left));
                    left++;
                }
            }

            //保存right出现的位置
            map.put(rightChKey, right);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
