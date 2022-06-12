package com.ymt.leetcode.two_pointers.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路:双指针+Map
 * 1. 固定left，right向右走到第一次出现重复的位置，计算最大长度
 * 2. 删除map中left位置的字符，枚举下一个left位置
 *
 * @author yumingtao
 * @date 2021/11/29 11:24
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int right = 0;

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        //枚举左端点
        for (int left = 0; left < len; left++) {
            while (right < len && !map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), right);
                right++;
            }
            //在[left, right]区间，map中包含了和right位置一样的字符
            //因为在while中，right已经加1了，所以这里是right-1-left+1
            maxLen = Math.max(maxLen, right - left);
            //移除当前map存储的left对应的字母，继续枚举下一个left
            map.remove(s.charAt(left));
        }
        return maxLen;
    }
}
