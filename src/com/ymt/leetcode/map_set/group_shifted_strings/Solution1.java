package com.ymt.leetcode.map_set.group_shifted_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 使用HashMap+key生成设计
 * 1. key的生成采用如下算法：
 * 1.1 第一字符与自己之间的距离是0
 * 1.2 从第二个字符开始，计算当前字符与前一个字符之间的距离再取模
 * 1.3 字符与字符之间的距离取模后使用"_"分隔
 * @author yumingtao
 * @date 2022-03-03 21:36
 */
public class Solution1 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = getKey(s);
            List<String> l = map.getOrDefault(key, new ArrayList<>());
            l.add(s);
            map.put(key, l);
        }
        List<List<String>> ans = new ArrayList();
        map.forEach((k, v) -> ans.add(v));
        return ans;
    }

    private String getKey(String s) {
        //如果只包含一个字符，直接返回0
        if (s.length() == 0) {
            return "0";
        }

        char[] chs = s.toCharArray();
        StringBuilder sb = new StringBuilder("0");
        for (int i = 1; i < chs.length; ++i) {
            sb.append("_");
            int distance = chs[i] - chs[i - 1];
            if (distance < 0) {
                distance += 26;
            }
            sb.append(distance % 26);
        }
        return sb.toString();
    }
}
