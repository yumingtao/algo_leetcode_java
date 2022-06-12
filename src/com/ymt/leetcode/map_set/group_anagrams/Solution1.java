package com.ymt.leetcode.map_set.group_anagrams;

import java.util.*;

/**
 * @Description TODO
 * @author yumingtao
 * @date 2022-03-03 19:57
 */
public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = getKey(s);
            List<String> l = map.getOrDefault(key, new ArrayList<>());
            l.add(s);
            map.put(key, l);
        }
        List<List<String>> ans = new ArrayList<>();
        map.forEach((k, v) -> ans.add(v));
        return ans;
    }

    private String getKey(String s) {
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}
