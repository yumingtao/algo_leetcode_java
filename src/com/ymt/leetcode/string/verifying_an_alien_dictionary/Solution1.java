package com.ymt.leetcode.string.verifying_an_alien_dictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @author yumingtao
 * @date 2022-11-29 23:19
 */
public class Solution1 {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) {
            return true;
        }
        // 预处理顺序
        Map<Character, Integer> orderDic = new HashMap<>();
        for (int i = 0; i < order.length(); ++i) {
            orderDic.put(order.charAt(i), i);
        }

        // 逐一比较
        String previous = words[0];
        for (int i = 1; i < words.length; ++i) {
            String current = words[i];
            int n = Math.min(previous.length(), current.length());
            int index = 0;
            while (index < n) {
                int previousOrder = orderDic.get(previous.charAt(index));
                int currentOrder = orderDic.get(current.charAt(index));
                if (previousOrder > currentOrder) {
                    // 不满足顺序，直接返回false
                    return false;
                } else if (previousOrder < currentOrder) {
                    // 满足顺序直接跳出循环，比较下一个单词
                    break;
                }
                ++index;
                if (index == n && previous.length() > current.length()) {
                    // 如果循环完最短单词，字母相同，但是前一个单词的长度比当前单词长，直接返回false
                    return false;
                }
            }
            previous = current;
        }
        return true;
    }
}
