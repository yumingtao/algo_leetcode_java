package com.ymt.leetcode.map_set.example;

import java.util.HashMap;

/**
 * @Description
 * @author yumingtao
 * @date 2022-02-27 15:23
 */
public class Example {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer curVale = map.putIfAbsent(1, 100);
        System.out.println("curValue-1:"+ curVale);

        curVale = map.putIfAbsent(1, 1000);
        System.out.println("curValue-2:" + curVale);
    }
}
