package com.ymt.leetcode.map_set.minimum_index_sum_of_two_lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 使用HashMap和List
 * @author yumingtao
 * @date 2022-02-27 19:24
 */
public class Solution2 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<Integer, List<String>> sumMap = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; ++i) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; ++i) {
            if (map.containsKey(list2[i])) {
                int sum = map.get(list2[i]) + i;
                List<String> list = sumMap.getOrDefault(sum, new ArrayList<String>());
                list.add(list2[i]);
                sumMap.put(sum, list);
            }
        }
        int minSum = 2001;
        for (int sum : sumMap.keySet()) {
            minSum = Math.min(minSum, sum);
        }
        List<String> minSumList = sumMap.get(minSum);
        String[] ans = new String[minSumList.size()];
        /*List<String> minSumList = sumMap.get(minSum);
        String[] ans = new String[minSumList.size()];
        return minSumList.toArray(ans);*/
        for (int i = 0; i < minSumList.size(); ++i) {
            ans[i] = minSumList.get(i);
        }
        return ans;
    }
}
