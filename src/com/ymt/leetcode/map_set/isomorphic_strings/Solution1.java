package com.ymt.leetcode.map_set.isomorphic_strings;

import java.util.HashMap;

/**
 * @Description 使用双HashMap
 * @author yumingtao
 * @date 2022-02-27 15:38
 */
public class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        //s和t对应位置的映射关系
        HashMap<Character, Character> sMap = new HashMap<>();
        //t和s对应位置的映射关系
        HashMap<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            //以s中字符做为key判断
            if (!sMap.containsKey(sArr[i])) {
                //以t中字符做为key判断
                if (tMap.containsKey(tArr[i])) {
                    //如果tMap中包含ttArr[i]，说明已经映射给s中的其它字符
                    return false;
                }
                sMap.put(sArr[i], tArr[i]);
                tMap.put(tArr[i], sArr[i]);
            } else {
                //如果包含了映射，但是和t当前位置的字符不相同，返回false
                if (sMap.get(sArr[i]) != tArr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
